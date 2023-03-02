package com.kusitms.website.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CorporateResponse {
    private int corporateCount;
    private List<CorporateDetailResponse> corporateList;
}
