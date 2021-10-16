package mockito;

import com.example.mockiito.DataService;
import com.example.mockiito.SomeBusinessImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessTest {
    @Mock
    private DataService dataService;

    @Before
    public void before(){
        /*
        DataService dataService = mock(DataService.class);  this is another way to create a mock
        but you have to do it in every test
         */

        when(dataService.retrieveAllData()).thenReturn(Arrays.asList(75,45,76));
    }

    @Test
    public void findTheGreatest(){
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataService.retrieveAllData());
        int num = someBusiness.findTheGreatest();
        someBusiness.retrieveAllData();
       assertEquals(num, 76);
    }

    @Test
    public void findTheGreatestWithMultipleThenReturn(){
        SomeBusinessImpl someBusiness = mock(SomeBusinessImpl.class);
        /*
        when calling .thenReturn once means it will return 45 when(someBusiness.findTheGreatest()) is called once
        but if we call it second time then second thenReturn value(100) will get returned.
         */
        when(someBusiness.findTheGreatest()).thenReturn(45).thenReturn(100);
        assertThat(someBusiness.findTheGreatest(), is(45));
        assertThat(someBusiness.findTheGreatest(), is(100));
    }

    @Test
    public void testList_withSpecificGet(){
        /*
        In this test case you can return the value for specific value
            for example we are checking for example 0
         */
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("value zero");
        assertThat(mockList.get(0), is("value zero"));
    }

    @Test
    public void testList_withGenericGet(){
        /*
        In this test case you can return the value for generic value
            for example we are checking for any integer for example 5
         */
        List mockList = mock(List.class);
        when(mockList.get(Mockito.anyInt())).thenReturn("Generic value");
        assertThat(mockList.get(5), is("Generic value"));
    }
}
