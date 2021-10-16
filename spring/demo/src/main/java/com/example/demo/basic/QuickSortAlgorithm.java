package com.example.demo.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "Quick")
public class QuickSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort() {

    }
}
