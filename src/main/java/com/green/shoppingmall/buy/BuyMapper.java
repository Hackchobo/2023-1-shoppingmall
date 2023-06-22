package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.CustomerGetVo;
import com.green.shoppingmall.buy.model.InsBuyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuyMapper {
    int insBuy(InsBuyDto dto);
    List<CustomerGetVo> selCustomer();
}
