package com.kevinferrer.deployment.controller;

import com.kevinferrer.deployment.domain.DeploymentEntity;
import com.kevinferrer.deployment.service.DeploymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deployments")
public class DeploymentController {

    private final DeploymentService deploymentService;

    public DeploymentController(DeploymentService deploymentService) {
        this.deploymentService = deploymentService;
    }

    @PostMapping
    public DeploymentEntity createDeployment(@RequestBody CreateDeploymentRequest request) {
        return deploymentService.createDeployment(
                request.getServiceName(),
                request.getEnvironmentName(),
                request.getVersion()
        );
    }

    public static class CreateDeploymentRequest {
        private String serviceName;
        private String environmentName;
        private String version;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getEnvironmentName() {
            return environmentName;
        }

        public void setEnvironmentName(String environmentName) {
            this.environmentName = environmentName;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
