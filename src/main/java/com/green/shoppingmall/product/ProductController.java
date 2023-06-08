package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.ProductEntity;
import com.green.shoppingmall.product.model.ProductInsDto;
import com.green.shoppingmall.product.model.SingSangSongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/file",consumes = {MediaType.APPLICATION_JSON_VALUE,
                                MediaType.MULTIPART_FORM_DATA_VALUE})
    // MultipartFile -> 폼데이터로 날라온다., RequestPart는 파일을 받을때 쓰는 것(폼데이터와 JSON)
    // RequestParam은 쿼리 스트링(?~~)에 사용 한다.
    // RequestBody는 하나 있을때 JSON으로 객체형태로 받는다.
    public int insProduct(@RequestPart ProductInsDto dto,
                          @RequestPart MultipartFile img){
        System.out.println(dto);
        System.out.println(img.getOriginalFilename());
        return service.insProduct(img, dto);
    }

    /*@PostMapping(value = "/file", consumes = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.MULTIPART_FORM_DATA_VALUE})
    public int insSinger(@RequestPart SingSangSongDto data, @RequestPart MultipartFile file){
        System.out.println(data);
        System.out.println(file.getOriginalFilename());
        return 0;
    }*/
}
