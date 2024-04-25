package com.turing.alan.whatsappclone.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turing.alan.whatsappclone.core.UserAlreadyExistsException;
import com.turing.alan.whatsappclone.user.domain.UserEntity;
import com.turing.alan.whatsappclone.user.domain.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getOne(long id) {
        
        UserEntity user = this.userRepository.findById(id).orElseThrow();
        //UserEntity user =this.userRepository.findById(id).orElseThrow({return new UserDoesNotExistsException()}})
        return user;
    }

    @Override
    public Optional<UserEntity> getOneByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public UserEntity create(UserEntity user) {
        // Añadir verificación de que el usuario no existe
        if (userRepository.existsByPhone(user.getPhone())) {
            throw new UserAlreadyExistsException();
        }
        return this.userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }

    @Override
    public Iterable<UserEntity> getAll() {
  
        return userRepository.findAll();
    }
    
}
