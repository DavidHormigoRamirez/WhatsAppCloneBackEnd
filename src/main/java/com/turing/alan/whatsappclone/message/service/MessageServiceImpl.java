package com.turing.alan.whatsappclone.message.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turing.alan.whatsappclone.message.domain.MessageEntity;
import com.turing.alan.whatsappclone.message.domain.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<MessageEntity> getOne(long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Iterable<MessageEntity> getAllbyUser(long id) {
        Iterable<MessageEntity> sended = messageRepository.findBySenderId(id);
        Iterable<MessageEntity> received = messageRepository.findByReceiverId(id);
        List<MessageEntity> messages = new ArrayList<>();
        sended.forEach(messages::add);
        received.forEach(messages::add);
        return messages;
    }

    @Override
    public void create(MessageEntity entity) {
        this.messageRepository.save(entity);
    }

    @Override
    public void deleteAll() {
        this.messageRepository.deleteAll();
    }
    
}
