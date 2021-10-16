package com.example.demo.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "Bubble")
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{
    @Override
    public void sort() {

    }
}
