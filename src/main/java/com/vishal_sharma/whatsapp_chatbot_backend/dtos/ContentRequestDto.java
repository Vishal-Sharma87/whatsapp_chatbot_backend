package com.vishal_sharma.whatsapp_chatbot_backend.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContentRequestDto {

    @NotNull(message = "Please tell me your name")
    private String username;

    @NotNull(message = "Send at-least one message character")
    private String message;
}
