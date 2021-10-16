package com.example.demo.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class  BinarySearchImplementation {
    private Logger logger = LoggerFactory.getLogger(BinarySearchImplementation.class);

    @Qualifier("Bubble")
    @Autowired
    private SortAlgorithm sortAlgorithm;

    public BinarySearchImplementation(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int num, List<Integer> list){
        sortAlgorithm.sort(); /// do the sorting here
        return 3;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("checking in postconstruct");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("checking in predestroy");
    }
}
