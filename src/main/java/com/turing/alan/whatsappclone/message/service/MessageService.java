package com.turing.alan.whatsappclone.message.service;

import java.util.Optional;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;

public interface MessageService {
    
    Optional<MessageEntity> getOne(long id);
    Iterable<MessageEntity> getAllbyUser(long id);
    Iterable<MessageEntity> getAllByUsers(long user1Id,long user2Id);
    void create(MessageEntity entity);
    void deleteAll();
}
