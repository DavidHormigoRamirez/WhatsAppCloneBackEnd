package com.turing.alan.whatsappclone.message.domain;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity,Long>{
    
    public Iterable<MessageEntity> findBySenderId(long id);
    public Iterable<MessageEntity> findByReceiverId(long id);

    public Iterable<MessageEntity> findBySenderIdAndReceiverId(long senderId,long receiverId);
}
