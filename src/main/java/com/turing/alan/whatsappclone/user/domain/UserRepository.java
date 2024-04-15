package com.turing.alan.whatsappclone.user.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    
    public Optional<UserEntity> findByPhone(String phone);
    public boolean existsByPhone(String phone);
}
