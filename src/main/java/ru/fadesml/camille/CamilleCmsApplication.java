package ru.fadesml.camille;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
@RequiredArgsConstructor
public class CamilleCmsApplication implements CommandLineRunner {
    private final DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(CamilleCmsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }

}
