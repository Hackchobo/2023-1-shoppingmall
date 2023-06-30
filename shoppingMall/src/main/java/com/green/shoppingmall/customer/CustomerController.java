package com.green.shoppingmall.customer;

import com.green.shoppingmall.customer.model.CustomerGetVo;
import com.green.shoppingmall.customer.model.CustomerInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    /customer 고객
    (post) 회원가입
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> PostCustomer(@RequestBody CustomerInsDto dto){
        int result = service.insCustomer(dto);
        return ResponseEntity.ok(result); // 리스판하면 오류뜨는상황에서 200을 나타낸다. 선언은 ResponseEntity<Integer> 이걸로 선언을 해주어야 된다.
//        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public ResponseEntity<List<CustomerGetVo>> getCustomer() {
        return ResponseEntity.ok(service.selCustomer());
    }
}
