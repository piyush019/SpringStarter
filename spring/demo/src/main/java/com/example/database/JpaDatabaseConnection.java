package com.example.database;

import com.example.database.entity.JpaPerson;
import com.example.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class JpaDatabaseConnection implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(JpaDatabaseConnection.class);
    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
      SpringApplication.run(JpaDatabaseConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         logger.info("Person with id {}", personJpaRepository.update(new JpaPerson("Tanjiro", "Tokyo", Timestamp.from(Instant.now()))));
        logger.info("Person {}", personJpaRepository.findAll());
        logger.info("Person with id {}", personJpaRepository.findById(1));
//     personJpaRepository.deleteById(1001);
    }
}
