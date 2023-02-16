package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.OrderDetailDTO;
import com.prm.group6.model.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    OrderDetailDTO orderDetailToOrderDetailDto(OrderDetail orderDetail);
    OrderDetail orderDetailDtoDtoToOrderDetail(OrderDetailDTO orderDetailDto);
}
