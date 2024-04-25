package com.turing.alan.whatsappclone.message.adapter;

import org.springframework.web.bind.annotation.RestController;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;
import com.turing.alan.whatsappclone.message.service.MessageService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController(value = "/message")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public MessageEntity getOne(@PathParam(value = "id") long id) {
        return messageService.getOne(id);
    }

    @GetMapping
    public Iterable<MessageEntity> getAll(@RequestParam(name="user") long userId) {
        return this.messageService.getAllbyUser(userId);
    }
    
}
