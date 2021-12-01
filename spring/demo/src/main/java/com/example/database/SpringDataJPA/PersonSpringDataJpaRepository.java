package com.example.database.SpringDataJPA;


import com.example.database.entity.JpaPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataJpaRepository extends JpaRepository<JpaPerson, Integer> {
}
