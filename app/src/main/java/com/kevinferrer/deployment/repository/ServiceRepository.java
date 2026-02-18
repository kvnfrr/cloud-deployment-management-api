package com.kevinferrer.deployment.repository;

import com.kevinferrer.deployment.domain.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<ServiceEntity, UUID> {

    Optional<ServiceEntity> findByName(String name);
}
