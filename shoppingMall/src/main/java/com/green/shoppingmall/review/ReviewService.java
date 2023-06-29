package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper mapper;

    public int insReview(List<MultipartFile> file, ReviewInsDto dto){
        dto.setPics(file);
        return mapper.insReview(dto);
    }
}
