package com.technical.recruitment.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({""})
@EnableJpaRepositories("com.technical.recruitment.platform.repository")
@EntityScan(basePackages = {"com.technical.recruitment.platform.model"})
@EnableScheduling
@Configuration
public class TechincalRecruitmentPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechincalRecruitmentPlatformApplication.class, args);
    }

}
