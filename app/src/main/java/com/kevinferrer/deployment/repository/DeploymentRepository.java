package com.kevinferrer.deployment.repository;

import com.kevinferrer.deployment.domain.DeploymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeploymentRepository extends JpaRepository<DeploymentEntity, UUID> {
}
