package com.example.database.jdbc;

import com.example.database.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {
    //jdbcConnection
    @Autowired
    JdbcTemplate jdbcTemplate;

    // select * from person
    public List<Person> findAll(){
        return jdbcTemplate.query("select * from person" , new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id} , new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findByName(String name){
        return jdbcTemplate.queryForObject("select * from person where name =?", new Object[] {name} , new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", id);
    }


    public int deleteByIdAndName(int id, String name){
        return jdbcTemplate.update("delete from person where id=? and name=?", id, name);
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into person(id, name, location, birth_date) values(?,?,?,?)" ,
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getDateOfBirth().getTime())});
    }

    public int update(Person person){
        return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
                person.getName(), person.getLocation(), new Timestamp(person.getDateOfBirth().getTime()), person.getId());
    }


    // How to define your own custom Row mapper if in the case field name in Bean is different than column name in table in DB

    class CustomPersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setDateOfBirth(rs.getTimestamp("birth_date"));

            return person;
        }
    }

    public Person findByIdUsingCustomRowMapper(int id){
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new CustomPersonRowMapper());
    }

}
