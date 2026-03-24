package com.vishal_sharma.whatsapp_chatbot_backend.dtos;

import lombok.Data;

import java.time.Instant;


@Data
public class ApiResponseDto<T> {

    private T apiResponse;
    private Instant timestamp;

    public ApiResponseDto(T apiResponse){
        this.apiResponse = apiResponse;
        this.timestamp = Instant.now();
    }
}
