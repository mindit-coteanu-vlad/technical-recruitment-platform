package com.technical.recruitment.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({"com.technical.recruitment.platform"})
@EnableJpaRepositories("com.technical.recruitment.platform.repository")
@EntityScan({"com.technical.recruitment.platform"})
@ComponentScan({"com.technical.recruitment.platform"})
@EnableScheduling
@Configuration
public class TechnicalRecruitmentPlatformApplication {

    public static void main(String[] args) {

        SpringApplication.run(TechnicalRecruitmentPlatformApplication.class, args);
    }

}
