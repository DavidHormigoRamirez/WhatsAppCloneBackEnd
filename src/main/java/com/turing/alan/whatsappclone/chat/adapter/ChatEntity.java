package com.turing.alan.whatsappclone.chat.adapter;

import java.util.Set;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;
import com.turing.alan.whatsappclone.user.domain.UserEntity;




public class ChatEntity {

    private long id;
    private Set<UserEntity> contacts;
    private Iterable<MessageEntity> messages;
    
}
