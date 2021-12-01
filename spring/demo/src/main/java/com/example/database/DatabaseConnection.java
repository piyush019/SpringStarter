package com.example.database;

import com.example.database.entity.Person;
import com.example.database.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import static org.apache.tomcat.jni.Time.now;

//@SpringBootApplication
public class DatabaseConnection implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    @Autowired
    PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
      SpringApplication.run(DatabaseConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("find all user -> {}", personJdbcDao.findAll());
        logger.info("person with 1001 id is {}", personJdbcDao.findById(1001));
        logger.info("person with Naruto name is {}", personJdbcDao.findByName("Naruto"));
//        logger.info("delete with 1001 id {}", personJdbcDao.deleteById(1001));
        logger.info("delete with 1004 id  and Piyush name {}", personJdbcDao.deleteByIdAndName(1004, "Piyush"));
        logger.info("insert into table {}", personJdbcDao.insert(new Person(1005, "Eren Yeager", "Paradise", Timestamp.from(Instant.now()))));
        logger.info("update into table {}", personJdbcDao.update(new Person(1006, "Demon of Paradise", "Marlin", Timestamp.from(Instant.now()))));
        logger.info("person with 1005 id is {}", personJdbcDao.findByIdUsingCustomRowMapper(1005));
    }
}
