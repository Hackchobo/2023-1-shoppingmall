package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.CustomerGetVo;
import com.green.shoppingmall.buy.model.InsBuyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuySevice {

    private final BuyMapper mapper;

    public Long insBuy(InsBuyDto dto){
        int result = mapper.insBuy(dto);
        return Long.valueOf(result);
    }

    public List<CustomerGetVo> selCustomer(){
        return mapper.selCustomer();
    }
}
