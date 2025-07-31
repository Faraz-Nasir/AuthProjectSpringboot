package com.example.jwt.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jwt.Entities.UserRegisterEntity;

@Repository
public interface UserRegisterEntityRepository extends JpaRepository<UserRegisterEntity,Long> {
    Optional<UserRegisterEntity> findByUsername(String username);
}
