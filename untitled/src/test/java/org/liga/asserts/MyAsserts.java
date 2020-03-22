package org.liga.asserts;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MyAsserts {

    public static void assertEquals(Object first, Object second) {
        if (!first.equals(second))
            System.err.println("Проверка на равенство провалена");
        else
            System.out.println("Проверка на равенство выполнена");
    }

    public static void assertTrue(Object obj) {
        if (obj.equals(false))
            System.err.println("Проверка на true провалена");
        else
            System.out.println("Проверка на true выполнена");
    }

    public static void assertNotNull(Object obj) {
        if (obj == null)
            System.err.println("Проверка на null провалена");
        else
            System.out.println("Проверка на null выполнена");
    }
}
