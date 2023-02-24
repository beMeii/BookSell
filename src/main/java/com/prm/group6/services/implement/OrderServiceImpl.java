package com.prm.group6.services.implement;

import com.prm.group6.model.dto.*;
import com.prm.group6.model.entity.*;
import com.prm.group6.repositories.*;
import com.prm.group6.services.CartService;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.OrderService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.OrderDetailMapper;
import com.prm.group6.services.mappers.OrderMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
    @Override
    public List<@Valid OrderDTO> getOrderListForUser(String token) {
        Account acc = jwtService.getAccount(token);
        List<OrderDTO>  orderDTOList = new ArrayList<>();
        List<Order> orderList = orderRepository.findAllByCustomerId(acc.getAccountId());
        orderList.forEach(order -> {
            OrderDTO orderDTO = OrderMapper.INSTANCE.orderToOrderDto(order);
            orderDTO.setOrderId(order.getOrderId());
            orderDTOList.add(orderDTO);
            }
        );
        return orderDTOList;
    }
    @Override
    public List<OrderDetailDTO> getOrderDetails(String token, int id) {
        Account acc = jwtService.getAccount(token);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrder_OrderIdAndOrder_CustomerId(id, acc.getAccountId());
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
        if (paymentDTO.getAddress()!=null) order.setAddress(paymentDTO.getAddress());
        if (paymentDTO.getPhone()!=null) order.setPhone(paymentDTO.getPhone());


        System.out.println(order);
        saveOrderDetail(cart,orderRepository.save(order));
        cartService.deleteCart(token);
        return OrderMapper.INSTANCE.orderToOrderDto(order);
    }

    @Transactional
    private void saveOrderDetail(List<CartDTO> cart,Order order){
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartDTO cartDTO:cart){
            OrderDetail orderDetail = new OrderDetail().builder()
                    .price(cartDTO.getBookDTO().getPrice())
                    .quantity(cartDTO.getQuantity())
                    .book(BookMapper.INSTANCE.bookDtoToBook(cartDTO.getBookDTO()))
                    .order(order)
                    .build();
            orderDetailList.add(orderDetail);
        }
        orderDetailRepository.saveAll(orderDetailList);
    }

    private float getTotalAmount(List<CartDTO> cart){
        float totalAmount = 0;
        for (CartDTO cartDTO: cart){
            totalAmount += cartDTO.getBookDTO().getPrice() * cartDTO.getQuantity();
        }
        return totalAmount;
    }

}
