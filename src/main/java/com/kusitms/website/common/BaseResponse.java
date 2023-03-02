package com.kusitms.website.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import static com.kusitms.website.common.BaseExceptionStatus.SUCCESS;

@Data
@JsonPropertyOrder({"code", "message", "data"})
public class BaseResponse<T> {
    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public BaseResponse(T data) {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
        this.data = data;
    }

    public BaseResponse() {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
    }
}
