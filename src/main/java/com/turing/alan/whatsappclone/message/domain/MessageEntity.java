package com.turing.alan.whatsappclone.message.domain;

import java.time.Instant;

import com.turing.alan.whatsappclone.user.domain.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "message")
public class MessageEntity implements Comparable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable=false)
    private String text;

    private Instant timeSent;

    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false,updatable = false)
    private UserEntity sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false, updatable = false)
    private UserEntity receiver;
    public MessageEntity(String text, Instant timeSent,UserEntity sender, UserEntity receiver) {
        this.id = 0;
        this.text = text;
        this.timeSent = timeSent;
        this.sender = sender;
        this.receiver = receiver;
    }
    protected MessageEntity() {}

    public UserEntity getSender() {
        return sender;
    }
    public void setSender(UserEntity sender) {
        this.sender = sender;
    }
    public UserEntity getReceiver() {
        return receiver;
    }
    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Instant getTimeSent() {
        return timeSent;
    }
    public void setTimeSent(Instant timeSent) {
        this.timeSent = timeSent;
    }
    @Override
    public int compareTo(Object o) {
        MessageEntity entity = (MessageEntity) o;

        if (entity.getTimeSent().isAfter(this.getTimeSent())) {
            return -1;
        }
        else {
            return 1;
        }


    }
}
