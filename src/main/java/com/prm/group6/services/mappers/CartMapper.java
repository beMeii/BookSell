package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.CartDTO;
import com.prm.group6.model.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
    CartDTO cartToCartDto(Cart cart);
    Cart cartDtoToCart(CartDTO cartDTO);
}
