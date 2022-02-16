package com.example.convertAPI.model.repository;

import com.example.convertAPI.model.entity.InitialFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialFileEntityRepository extends JpaRepository<InitialFileEntity, Long> {
}
