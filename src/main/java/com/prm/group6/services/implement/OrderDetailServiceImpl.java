package com.prm.group6.services.implement;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.OrderDetail;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.OrderDetailRepository;
import com.prm.group6.repositories.OrderRepository;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.OrderDetailService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    JwtService jwtService;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<OrderDetailDTO> getOrderDetails(String token, String id) {
        token = token.substring(7);
        String userName=jwtService.extractEmail(token);
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        //-----------------------------------------------------------------
        //Check người gửi request có quyền xem details của cái order này không
        if (accountRepository.findByEmail(userName).get().getAccountId() ==
                orderRepository.findById(Integer.parseInt(id)).get().getCustomerId()){
            List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrderId(Integer.parseInt(id));
            orderDetailList.forEach(OrderDetail -> {
                        OrderDetailDTO orderDetailDTO = OrderDetailMapper.INSTANCE.orderDetailToOrderDetailDto(OrderDetail);
                        Book book = bookRepository.findByBookId(OrderDetail.getBookId());
                        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDto(book);
                        orderDetailDTO.setBook(bookDTO);
                        orderDetailDTOList.add(orderDetailDTO);
                    }
            );
        };
        return orderDetailDTOList;
    }
}
