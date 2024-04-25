package com.turing.alan.whatsappclone.chat.adapter;

import org.springframework.web.bind.annotation.RestController;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;
import com.turing.alan.whatsappclone.message.service.MessageService;
import com.turing.alan.whatsappclone.user.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ChatController {

    MessageService messageService;
    UserService userService;

    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }
    
    @GetMapping("/chat")
    public Iterable<MessageEntity> getChats(@RequestParam(name = "user1") long user1,
                                            @RequestParam(name = "user2") long user2)  {

        //Iterable<MessageEntity> messages1 
        return messageService.getAllByUsers(user1, user2);

    
    }
    
}
