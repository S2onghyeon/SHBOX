package com.example.my.model.user.repository;

import com.example.my.model.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username); //todo: select username from 'user' where name =? 같은뜻임

    Optional<UserEntity> findByUsernameAndDeleteDateIsNull(String username); //todo: select username from 'user' where username =? and delete_date is null;

    Optional<UserEntity> findByIdAndDeleteDateIsNull(Long id); //todo: select id from 'user' where username = ? and delete_date is null
}
