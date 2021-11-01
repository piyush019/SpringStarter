package com.example.aop.data;

import com.example.util.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public Object retreiveSomething(){
        return (String) "Dao1";
    }
}
