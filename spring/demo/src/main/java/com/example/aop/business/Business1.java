package com.example.aop.business;

import com.example.aop.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    public Object calculateSomething(){
        return dao1.retreiveSomething();
    }
}
