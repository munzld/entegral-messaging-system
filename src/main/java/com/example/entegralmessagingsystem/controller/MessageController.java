package com.example.entegralmessagingsystem.controller;

import com.example.entegralmessagingsystem.model.message.Message;
import com.example.entegralmessagingsystem.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messagingService) {
        this.messageService = messagingService;
    }

    @PostMapping(value = "/message/{companyId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@PathVariable String companyId, @RequestBody Message message) {
        this.messageService.sendMessageToCompany(companyId, message);
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessages(@RequestBody Message message) {
        this.messageService.sendMessageToAllCompanies(message);
    }

}
