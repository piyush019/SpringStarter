package com.example.demo.cdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SomeCdiBusiness {
    @Autowired
    private SomeCdiDAO someCdiDAO;

    public SomeCdiBusiness(SomeCdiDAO someCdiDAO) {
        this.someCdiDAO = someCdiDAO;
    }


    public SomeCdiDAO getSomeCdiDAO() {
        return someCdiDAO;
    }

    public void setSomeCdiDAO(SomeCdiDAO someCdiDAO) {
        this.someCdiDAO = someCdiDAO;
    }

    public int findTheGreatest(){
        int greatest = Integer.MIN_VALUE;
        List<Integer> data = someCdiDAO.getData();
        for (int value : data){
            if (value> greatest){
                greatest = value;
            }
        }
        return greatest;
    }
}
