package com.koapti.lazychef.repository;

import com.koapti.lazychef.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}