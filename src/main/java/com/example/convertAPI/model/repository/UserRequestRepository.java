package com.example.convertAPI.model.repository;

import com.example.convertAPI.model.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
}
