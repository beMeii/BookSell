package com.prm.group6.services.implement;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.prm.group6.model.OrderStatusEnum;
import com.prm.group6.model.dto.*;
import com.prm.group6.model.entity.*;
import com.prm.group6.repositories.*;
import com.prm.group6.services.*;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.OrderDetailMapper;
import com.prm.group6.services.mappers.OrderMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.PageRequest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class OrderServiceImpl implements OrderService {
    @Autowired
    JwtService jwtService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    CartService cartService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private FirebaseMessagingService firebaseMessagingService;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    NotificationService notificationService;

    @Override
    public List<@Valid OrderDTO> getOrderListForUser(String token, int pageNo, int pageSize, String sort) {
        Account acc = jwtService.getAccount(token);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        List<Order> orderList = orderRepository.findAllByCustomerId(acc.getAccountId(), pageable);
        orderList.forEach(order -> {
                    OrderDTO orderDTO = OrderMapper.INSTANCE.orderToOrderDto(order);
                    orderDTO.setOrderId(order.getOrderId());
                    orderDTOList.add(orderDTO);
                }
        );
        return orderDTOList;
    }

    @Override
    public List<OrderDetailDTO> getOrderDetails(String token, int id, int pageNo, int pageSize) {
        Account acc = jwtService.getAccount(token);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrder_OrderIdAndOrder_CustomerId(id, acc.getAccountId(), pageable);
        orderDetailList.forEach(orderDetail -> {
                    Book book = orderDetail.getBook();
                    OrderDetailDTO orderDetailDTO = OrderDetailMapper.INSTANCE.orderDetailToOrderDetailDto(orderDetail);
                    BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDto(book);
                    orderDetailDTO.setBook(bookDTO);
                    orderDetailDTOList.add(orderDetailDTO);
                }
        );
        return orderDetailDTOList;
    }

    @Override
    public List<OrderDTO> getAllOrder(int pageNo, int pageSize, String sort, String sortType) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        orderRepository.findAll(pageable).forEach(order -> {
                    OrderDTO orderDTO = OrderMapper.INSTANCE.orderToOrderDto(order);
                    orderDTO.setOrderId(order.getOrderId());
                    orderDTOList.add(orderDTO);
                }
        );
        return orderDTOList;
    }

    @Override
    public OrderDTO changeStatus(int orderId, OrderStatusEnum status) {
        Order order = orderRepository.findByOrderId(orderId);
        order.setStatus(status.name());
        orderRepository.save(order);

        int customerId = order.getCustomerId();
//        String deviceToken = customerRepository.findDeviceTokenByCustomerId(customerId);
        String deviceToken = "eMTW-e3TTzy4pXvc7o9kYh:APA91bG5bByjj7g9TByJdnebFurN39kksZytv4f1y_Svg8B1tgFNNnvM9gAFx5rGuDLKWAQQ9E0fo0OVyJGYXi2Z0pVx18IvE6Ml0wTjNcCpQHiIQBCE0pz9akcHE86-8cd4Z7AvK5ms";

        List<String> deviceTokenList = new ArrayList<>();
        deviceTokenList.add(deviceToken != null ? deviceToken : "");

        try {
            String title = "";
            String body = "";
            if (status.name().equals("pending")) {
                title = "Your order is now processing.";
                body = "We will let you know if your order is being delivered.";
            } else if (status.name().equals("delivered")) {
                title = "Your order is now delivering.";
                body = "It takes several days for the packages get to yours.";
            } else if (status.name().equals("canceled")) {
                title = "Your order is canceled.";
                body = "There may be a reason for your order being canceled. Please contact us if you need help.";
            }
            firebaseMessagingService.sendNotifications(
                    title,
                    body,
                    deviceTokenList);
            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.setTitle(title);
            notificationDTO.setBody(body);
//            notificationDTO.setTime(new Timestamp(System.currentTimeMillis()));

            NotificationDTO notificationDTOResponse = notificationService.addNotification(notificationDTO, customerId);
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }


        return OrderMapper.INSTANCE.orderToOrderDto(order);
    }

    @Override
    public List<OrderDetailDTO> adminGetOrderDetails(int id) {
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrder_OrderId(id);
        orderDetailList.forEach(orderDetail -> {
                    Book book = orderDetail.getBook();
                    OrderDetailDTO orderDetailDTO = OrderDetailMapper.INSTANCE.orderDetailToOrderDetailDto(orderDetail);
                    BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDto(book);
                    orderDetailDTO.setBook(bookDTO);
                    orderDetailDTOList.add(orderDetailDTO);
                }
        );
        return orderDetailDTOList;
    }

    @Override
    @Transactional
    public @Valid OrderDTO addOrder(String token, PaymentDTO paymentDTO) {
        Customer customer = jwtService.getCustomer(token);
        List<CartDTO> cart = cartService.getCart(token);
        //--------------build cái order nè-------------------------
        Order order = new Order(); //.builder()
        order.setAddress(customer.getAddress());
        order.setPhone(customer.getPhone());
        order.setTime(new Timestamp(System.currentTimeMillis()));
        order.setCustomerId(customer.getCustomerId());
        order.setStatus("pending");
        order.setTotal_amount(getTotalAmount(cart));


        //đè lại giá trị address với phone
        if (paymentDTO.getAddress() != null) order.setAddress(paymentDTO.getAddress());
        if (paymentDTO.getPhone() != null) order.setPhone(paymentDTO.getPhone());


        System.out.println(order);
        saveOrderDetail(cart, orderRepository.save(order));
        cartService.deleteCart(token);
        return OrderMapper.INSTANCE.orderToOrderDto(order);
    }

    @Transactional
    private void saveOrderDetail(List<CartDTO> cart, Order order) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartDTO cartDTO : cart) {
            OrderDetail orderDetail = new OrderDetail().builder()
                    .price(cartDTO.getBookDTO().getPrice())
                    .quantity(cartDTO.getQuantity())
                    .book(BookMapper.INSTANCE.bookDtoToBook(cartDTO.getBookDTO()))
                    .order(order)
                    .build();
            orderDetailList.add(orderDetail);
            Book b = orderDetail.getBook();
            b.setQuantityLeft(b.getQuantityLeft() - orderDetail.getQuantity());
            bookRepository.save(b);
        }
        orderDetailRepository.saveAll(orderDetailList);
    }

    private float getTotalAmount(List<CartDTO> cart) {
        float totalAmount = 0;
        for (CartDTO cartDTO : cart) {
            totalAmount += cartDTO.getBookDTO().getPrice() * cartDTO.getQuantity();
        }
        return totalAmount;
    }

}
