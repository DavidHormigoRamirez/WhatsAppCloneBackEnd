package com.turing.alan.whatsappclone.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turing.alan.whatsappclone.user.domain.UserEntity;
import com.turing.alan.whatsappclone.user.domain.UserRepository;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> getOne(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> getOneByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public void create(UserEntity user) {
        this.userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }
    
}
