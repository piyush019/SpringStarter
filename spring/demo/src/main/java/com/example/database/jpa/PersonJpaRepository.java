package com.example.database.jpa;

import com.example.database.entity.JpaPerson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//repository
//transaction
@Repository
@Transactional
public class PersonJpaRepository {

    //connect to database
    @PersistenceContext
    EntityManager entityManager;

    public List<JpaPerson> findAll(){
        TypedQuery<JpaPerson> find_all_data = entityManager.createNamedQuery("find_all_persons", JpaPerson.class);
        return find_all_data.getResultList();
    }

    public JpaPerson findById(int id){
        return entityManager.find(JpaPerson.class, id); //jpa
    }

    /*
        In JPA for both update and insert we use same entityManager.merge(T t)
        it checks the if Id is present then it updates the previous data otherwise adds a new one
     */
    public JpaPerson update(JpaPerson person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        JpaPerson person = findById(id);
        entityManager.remove(person);
    }
}
