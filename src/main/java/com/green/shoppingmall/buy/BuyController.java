package com.green.shoppingmall.buy;

import com.green.shoppingmall.buy.model.InsBuyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/buy")
@RequiredArgsConstructor
public class BuyController {

    private final BuySevice sevice;

    @PostMapping
    public ResponseEntity<Integer> PostBuy(@RequestBody InsBuyDto dto){
        return ResponseEntity.ok(Math.toIntExact(sevice.insBuy(dto)));
    }
}
