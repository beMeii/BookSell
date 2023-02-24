package com.prm.group6.services.implement;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.CartDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Cart;
import com.prm.group6.repositories.BookRepository;
import com.prm.group6.repositories.CartRepository;
import com.prm.group6.services.CartService;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.CartMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    JwtService jwtService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<CartDTO> getCart(String token) {
        Account acc = jwtService.getAccount(token);
        List<Cart> cart = cartRepository.findAllByAccount_AccountId(acc.getAccountId());
        List<CartDTO> cartDtoList = new ArrayList<>();
        if (!cart.isEmpty()){
            cart.forEach(item -> {
                BookDTO bookDto = BookMapper.INSTANCE.bookToBookDto(item.getBook());
                CartDTO cartDTO = CartMapper.INSTANCE.cartToCartDto(item);
                cartDTO.setBookDTO(bookDto);
                cartDtoList.add(cartDTO);
                }
            );
        }
        return cartDtoList;
    }

    @Override
    public List<@Valid CartDTO> addItemToCart(String token, int bookId, int value) {
        Account acc = jwtService.getAccount(token);
        Cart c = cartRepository.findByAccount_AccountIdAndBook_BookId(acc.getAccountId(),bookId); // kiểm tra món đó có trong giỏ hàng ch
        //trường hợp chưa có
        if (c==null){
            c = new Cart();
            c.setAccount(acc);
            c.setBook(bookRepository.findByBookId(bookId));
            c.setQuantity(value);
        }
        //trường hợp có
        else c.setQuantity(c.getQuantity()+value);
        // kiểm tra điều kiện trước khi save xuống db
        if (c.getQuantity()<=bookRepository.findByBookId(bookId).getQuantityLeft()){
            cartRepository.save(c);
            return getCart(token);
        }
        else return null;
    }

    @Override
    public List<CartDTO> deleteItemFromCart(String token, int bookId, int value) {
        Account acc = jwtService.getAccount(token);
        Cart c = cartRepository.findByAccount_AccountIdAndBook_BookId(acc.getAccountId(),bookId);
        if (c!=null){
            int quantity = c.getQuantity()-value;
            if (quantity <= 0){
                cartRepository.delete(c);
            }
            else {
                c.setQuantity(quantity);
                cartRepository.save(c);
            };
            return getCart(token);
        }
        else
            return null;
    }

    @Override
    public List<CartDTO> deleteCart(String token) {
        Account acc = jwtService.getAccount(token);
        List<Cart> cart = cartRepository.findAllByAccount_AccountId(acc.getAccountId());
        cart.forEach(cart1 -> {
            cartRepository.delete(cart1);
            }
        );
        return getCart(token);
    }

    @Override
    public List<CartDTO> deleteCartItem(String token, int bookId) {
        Account acc = jwtService.getAccount(token);
        List<Cart> cart = cartRepository.findAllByAccount_AccountIdAndBook_BookId(acc.getAccountId(),bookId);
        cart.forEach(cart1 -> {
            cartRepository.delete(cart1);
            }
        );
        return getCart(token);
    }
}
