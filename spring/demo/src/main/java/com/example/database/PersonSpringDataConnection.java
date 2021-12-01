package com.example.database;;

import com.example.database.SpringDataJPA.PersonSpringDataJpaRepository;
import com.example.database.entity.JpaPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

//@SpringBootApplication
public class PersonSpringDataConnection implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(PersonSpringDataConnection.class);

    @Autowired
    PersonSpringDataJpaRepository personSpringDataJpaRepository;

    public static void main(String[] args) {
      SpringApplication.run(PersonSpringDataConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("find all user -> {}", personSpringDataJpaRepository.findAll());
        logger.info("person with 1001 id is {}", personSpringDataJpaRepository.findById(1001));
        logger.info("insert into table {}", personSpringDataJpaRepository.save(new JpaPerson("Eren Yeager", "Paradise", Timestamp.from(Instant.now()))));
        logger.info("update into table {}", personSpringDataJpaRepository.save(new JpaPerson("Demon of Paradise", "Marlin", Timestamp.from(Instant.now()))));

    }
}
