package com.example.database.entity;

import java.sql.Time;
import java.sql.Timestamp;


public class Person {
    private int id;
    private String name;
    private String location;
    private Timestamp dateOfBirth;

    public Person() {} //because


    public Person(int id, String name, String location, Timestamp dateOfBirth) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
