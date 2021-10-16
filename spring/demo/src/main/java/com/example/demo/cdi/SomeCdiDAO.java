package com.example.demo.cdi;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SomeCdiDAO {
    public List<Integer> getData(){
        return Arrays.asList(45,455,100);
    }
}
