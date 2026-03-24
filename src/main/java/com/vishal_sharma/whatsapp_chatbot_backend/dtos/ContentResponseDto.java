package com.vishal_sharma.whatsapp_chatbot_backend.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentResponseDto{

    private String content;
    private String messageStatus;

}
