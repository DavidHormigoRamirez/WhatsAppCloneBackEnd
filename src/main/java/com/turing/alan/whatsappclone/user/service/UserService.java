package com.turing.alan.whatsappclone.user.service;

import java.util.Optional;

import com.turing.alan.whatsappclone.user.domain.UserEntity;

public interface UserService {

    public UserEntity getOne(long id);
    public Optional<UserEntity> getOneByPhone(String phone);
    public UserEntity create(UserEntity user);
    public void deleteAll();

    public Iterable<UserEntity> getAll();
    
}
