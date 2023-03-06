package com.kusitms.website.service;

import com.kusitms.website.domain.review.Review;
import com.kusitms.website.dto.review.ReviewDetailResponse;
import com.kusitms.website.dto.review.ReviewResponse;
import com.kusitms.website.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public ReviewResponse getReviews() {
        List<Review> findReviews = reviewRepository.findAll();

        List<ReviewDetailResponse> reviewDetailResponses = findReviews.stream()
                .map(r -> new ReviewDetailResponse(r.getReviewId(), r.getName(), r.getTeam(), r.getReview()))
                .collect(Collectors.toList());

        return ReviewResponse.builder()
                .reviewCount(findReviews.size())
                .reviewList(reviewDetailResponses)
                .build();
    }
}
