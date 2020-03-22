package org.liga;

//import org.junit.jupiter.api.Test;
import org.liga.annatations.After;
import org.liga.annatations.Before;
import org.liga.annatations.Test;

import static org.liga.asserts.MyAsserts.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    public static App calc;

    @Before
    public static void setup() {
        System.out.println("Start test");
    }

    @After
    public static void finish() {
        System.out.println("Finish test");
    }

    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }

    @Test
    public void objMustBeNotNull(){
        assertNotNull(1);
    }

    @Test
    public void objectsMustBeEquals(){
        int a = 1;
        int b = 1;
        assertEquals(a, b);
    }
}
