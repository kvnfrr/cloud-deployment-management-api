package com.kevinferrer.deployment.service;

import com.kevinferrer.deployment.domain.*;
import com.kevinferrer.deployment.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeploymentService {

    private final ServiceRepository serviceRepository;
    private final EnvironmentRepository environmentRepository;
    private final DeploymentRepository deploymentRepository;

    public DeploymentService(
            ServiceRepository serviceRepository,
            EnvironmentRepository environmentRepository,
            DeploymentRepository deploymentRepository
    ) {
        this.serviceRepository = serviceRepository;
        this.environmentRepository = environmentRepository;
        this.deploymentRepository = deploymentRepository;
    }

    @Transactional
    public DeploymentEntity createDeployment(String serviceName, String environmentName, String version) {

        ServiceEntity service = serviceRepository
                .findByName(serviceName)
                .orElseGet(() -> {
                    ServiceEntity newService = new ServiceEntity();
                    newService.setName(serviceName);
                    return serviceRepository.save(newService);
                });

        EnvironmentEntity environment = environmentRepository
                .findByName(environmentName)
                .orElseGet(() -> {
                    EnvironmentEntity newEnv = new EnvironmentEntity();
                    newEnv.setName(environmentName);
                    return environmentRepository.save(newEnv);
                });

        DeploymentEntity deployment = new DeploymentEntity();
        deployment.setVersion(version);
        deployment.setService(service);
        deployment.setEnvironment(environment);

        return deploymentRepository.save(deployment);
    }
}
