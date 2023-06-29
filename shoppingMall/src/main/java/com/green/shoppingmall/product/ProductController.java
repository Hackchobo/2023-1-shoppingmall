package com.green.shoppingmall.product;

import com.green.shoppingmall.product.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;


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

    @PostMapping(value="/{iproduct}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Long insProductPics(@PathVariable Long iproduct, @RequestPart List<MultipartFile> pics) throws Exception{
        return service.insProductPics(iproduct, pics);
    }

    /*@PostMapping(value = "/file", consumes = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.MULTIPART_FORM_DATA_VALUE})
    public int insSinger(@RequestPart SingSangSongDto data, @RequestPart MultipartFile file){
        System.out.println(data);
        System.out.println(file.getOriginalFilename());
        return 0;
    }*/
    @GetMapping
    public List<ProductVo> getProduct() {
        return service.selProduct();
    }

    @GetMapping("/{iproduct}")
    public ProductDetailResponse getProductDetail(@PathVariable Long iproduct) {
        return service.selProductDetail(new ProductGetDetailDto(iproduct));
    }


    //연습했음
    @PostMapping(value="/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public int singSangSong(@RequestPart MultipartFile file, @RequestPart SingSangSongDto data) {
        System.out.println(data);
        System.out.println(file.getOriginalFilename());
        return 0;
    }

}
