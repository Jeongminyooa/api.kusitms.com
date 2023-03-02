package com.kusitms.website.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kusitms.website.domain.project.CorporateProject;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class CorporateDetailResponse {
    @JsonProperty("corporate_id")
    private Long corporateId;
    private int cardinal;
    private String name;
    private String content;
    @JsonProperty("logo_url")
    private String logoUrl;
    private List<String> category;

    public CorporateDetailResponse(CorporateProject corporate) {
        this.corporateId = corporate.getCorporateId();
        this.cardinal = corporate.getCardinal();
        this.name = corporate.getName();
        this.content = corporate.getContent();
        this.logoUrl = corporate.getLogoUrl();
        this.category = splitCategory(corporate.getCategory());
    }

    private List<String> splitCategory(String categoryString) {
        return Arrays.asList(categoryString.split("#"));
    }
}
