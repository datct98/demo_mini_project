package com.example.project_ogini;

import com.example.project_ogini.model.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.project_ogini"}, exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ProjectOginiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectOginiApplication.class, args);
    }

}
