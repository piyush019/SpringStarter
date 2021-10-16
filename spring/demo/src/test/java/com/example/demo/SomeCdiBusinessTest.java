package com.example.demo;

import com.example.demo.cdi.SomeCdiBusiness;
import com.example.demo.cdi.SomeCdiDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {
    //create the mock of the dependencies
    @Mock
    private SomeCdiDAO someCdiDAO;

    //Inject the mock in main component
    @InjectMocks
    private SomeCdiBusiness cdiBusiness;

    @Before
    public void before(){
        when(someCdiDAO.getData()).thenReturn(Arrays.asList(45,45,100));
    }

    @Test
    public void testTheGreatest(){
//        SomeCdiBusiness cdiBusiness1 = new SomeCdiBusiness(someCdiDAO); this is another way to do this
//        int val = cdiBusiness1.findTheGreatest();
//        assertThat(val, is(100));


        int val = cdiBusiness.findTheGreatest();
        assertThat(val, is(100));
    }
}
