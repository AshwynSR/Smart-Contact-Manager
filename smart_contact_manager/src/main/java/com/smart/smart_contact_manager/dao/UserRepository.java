package com.smart.smart_contact_manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.smart_contact_manager.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
