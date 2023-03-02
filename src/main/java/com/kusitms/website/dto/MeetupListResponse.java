package com.kusitms.website.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MeetupListResponse {
    @JsonProperty("meetup_count")
    private int meetupCount;

    @JsonProperty("meetup_list")
    private List<MeetupResponse> meetupList;
}