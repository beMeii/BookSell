package com.prm.group6.services.mappers;
import com.prm.group6.model.dto.OrderDTO;
import com.prm.group6.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDTO orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDTO orderDto);
}
