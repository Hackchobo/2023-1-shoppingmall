package com.green.shoppingmall.review;

import com.green.shoppingmall.review.model.ReviewInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int insReview(ReviewInsDto dto);
    int insReviewPinc(List<ReviewInsDto> picList);

}
