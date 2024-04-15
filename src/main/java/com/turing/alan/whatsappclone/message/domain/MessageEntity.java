package com.turing.alan.whatsappclone.message.domain;

import com.turing.alan.whatsappclone.user.domain.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "message")
public class MessageEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "sender_id",nullable = false,updatable = false)
    private UserEntity sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false, updatable = false)
    private UserEntity receiver;

    protected MessageEntity() {}
    public MessageEntity(String text, UserEntity sender, UserEntity receiver) {
        this.id = 0;
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }
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



}
