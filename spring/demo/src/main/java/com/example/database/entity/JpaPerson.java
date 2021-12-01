package com.example.database.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
/*
    @Table is only used when we have different table name than Object
    here we have the same name for object and table
 */
//@Table(name = "table_Name")
@NamedQuery(name="find_all_persons", query = "select p from JpaPerson p")
public class JpaPerson {
    /*
     we have to use @Id and @Generated annotation
     to let framework know that 'id' is Primary key and hence we don't have to set it in constructor
     */
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int id;

    /*
        again we only need @Column when we have different column name
     */
//    @Column(name = "column_name")
    private String name;
    private String location;
    private Timestamp dateOfBirth;

    public JpaPerson() {

    }

    public JpaPerson(String name, String location, Timestamp dateOfBirth) {
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


}
