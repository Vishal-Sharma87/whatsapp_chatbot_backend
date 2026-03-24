package com.vishal_sharma.whatsapp_chatbot_backend.controllers;


import com.vishal_sharma.whatsapp_chatbot_backend.dtos.ApiResponseDto;
import com.vishal_sharma.whatsapp_chatbot_backend.dtos.ContentRequestDto;
import com.vishal_sharma.whatsapp_chatbot_backend.dtos.ContentResponseDto;
import com.vishal_sharma.whatsapp_chatbot_backend.services.ReceiveMessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receive")
public class ReceiveMessageController {

    private final ReceiveMessageService receiveMessageService;

//    Constructor injection
    public ReceiveMessageController(ReceiveMessageService messageService){
        this.receiveMessageService = messageService;
    }


    @GetMapping("/health")
    public String healthCHeck(){
        return "ok :)";
    }


    @PostMapping("/webhook")
    public ResponseEntity<ApiResponseDto<ContentResponseDto>> acceptContent(@Valid @RequestBody ContentRequestDto dto){
//        dummy service for future use case
        ContentResponseDto response = receiveMessageService.consume(dto);

        return ResponseEntity.ok(new ApiResponseDto<>(response));
    }
}
