package com.example.mockiito;

import java.util.ArrayList;
import java.util.List;

public class SomeBusinessImpl implements DataService{
    private List<Integer> allData;

    public SomeBusinessImpl(List<Integer> allData){
        this.allData = allData;
    }

    @Override
    public List<Integer> retrieveAllData() {
        return allData;
    }

    public int findTheGreatest(){
        int greatest = Integer.MIN_VALUE;
        for (int value : allData){
            if (value > greatest){
                greatest = value;
            }
        }

        return greatest;
    }
}
