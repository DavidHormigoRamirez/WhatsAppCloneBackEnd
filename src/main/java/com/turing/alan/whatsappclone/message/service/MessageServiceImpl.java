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

    @Override
    public Iterable<MessageEntity> getAllByUsers(long user1Id, long user2Id) {
        Iterable<MessageEntity> messages1 = messageRepository.findBySenderIdAndReceiverId(user1Id, user2Id);
        Iterable<MessageEntity> messages2 = messageRepository.findBySenderIdAndReceiverId(user2Id, user1Id);

        List<MessageEntity> messages = new ArrayList<>();
        messages1.forEach(messages::add);
        messages2.forEach(messages::add);
        messages.sort(null);
        return messages;
    }
    
}
