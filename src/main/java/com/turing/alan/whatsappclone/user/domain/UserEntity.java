package com.turing.alan.whatsappclone.user.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true,updatable = false, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "sender",targetEntity = com.turing.alan.whatsappclone.message.domain.MessageEntity.class)
    private List<UserEntity> senderMessages;
    @OneToMany(mappedBy = "receiver",targetEntity = com.turing.alan.whatsappclone.message.domain.MessageEntity.class)
    private List<UserEntity> recieverMessage;
    protected UserEntity() {}
    public UserEntity(String phone) {
        this.id = 0;
        this.phone = phone;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
