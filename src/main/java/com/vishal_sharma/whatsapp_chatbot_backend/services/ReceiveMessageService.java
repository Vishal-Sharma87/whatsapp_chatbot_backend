package com.vishal_sharma.whatsapp_chatbot_backend.services;

import com.vishal_sharma.whatsapp_chatbot_backend.dtos.ContentRequestDto;
import com.vishal_sharma.whatsapp_chatbot_backend.dtos.ContentResponseDto;
import com.vishal_sharma.whatsapp_chatbot_backend.enums.MessageStatus;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessageService {

    private ContentResponseDto buildContent(String username, String message){
        String reply = message + " " + username;
        return ContentResponseDto
                .builder()
                .content(reply)
                .messageStatus(MessageStatus.RECEIVED.toString())
                .build();
    }

    public ContentResponseDto consume(ContentRequestDto dto) {

        if(dto.getMessage().toLowerCase().contains("hi")){
            return buildContent(dto.getUsername(), "Hello");
        }else if (dto.getMessage().toLowerCase().contains("bye")){
            return buildContent(dto.getUsername(), "Good Bye");
        }
        return buildContent(dto.getUsername(), "Default message");
    }
}
