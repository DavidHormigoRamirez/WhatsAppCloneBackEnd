package com.turing.alan.whatsappclone.message.service;

import java.util.Optional;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;

public interface MessageService {
    
    Optional<MessageEntity> getOne(long id);
    Iterable<MessageEntity> getAllbyUser(long id);
    void create(MessageEntity entity);
    void deleteAll();
}
