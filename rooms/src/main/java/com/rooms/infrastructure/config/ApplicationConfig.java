package com.rooms.infrastructure.config;


import com.rooms.application.services.Services;
import com.rooms.application.usecases.*;
import com.rooms.domian.ports.out.RepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("applicationConfig")
public class ApplicationConfig {

    @Bean
    public Services services(RepositoryPort repositoryPort) {
        return new Services(
            new CreateUseCaseImpl(repositoryPort),
                new RetrieveUseCaseImpl(repositoryPort),
                new UpdateUseCaseImpl(repositoryPort),
                new DeleteUseCaseImpl(repositoryPort),
                new ExistsByIdUseCaseImpl(repositoryPort)
        );
    }
}
