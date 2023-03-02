package com.kusitms.website.dto.corporate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kusitms.website.domain.project.CorporateProject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@Schema
public class CorporateDetailResponse {
    @JsonProperty("corporate_id")
    @Schema(description = "기프 ID")
    private Long corporateId;
    @Schema(description = "프로젝트 진행 기수")
    private int cardinal;
    @Schema(description = "기업 이름")
    private String name;
    @Schema(description = "기프 과제 내용")
    private String content;
    @JsonProperty("logo_url")
    @Schema(description = "로고 이미지 URL")
    private String logoUrl;
    @Schema(description = "과제 분류")
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
