package com.example.demo;

import com.example.demo.basic.BinarySearchImplementation;
import com.example.demo.basic.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// here you have to load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class BinarySearchTest {

    // get this bean from the context
    @Autowired
    BinarySearchImplementation binarySearchImplementation;

    @Test
    public void test(){
        int value = binarySearchImplementation.binarySearch(4, Arrays.asList(1,2,5));
        assertThat(value, is(3));
    }
}
