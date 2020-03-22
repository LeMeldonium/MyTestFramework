package org.liga.framework;

import org.liga.annatations.*;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomJUnit {
    public static void start(String path) throws Exception {
        List<Class> classes;
        classes = getClasses(path);
        for (Class clas : classes) {
            Object object = clas.getConstructor().newInstance();
            List<Method> methodsBefore = getMethods(clas, Before.class);
            List<Method> methodsTest = getMethods(clas, Test.class);
            List<Method> methodsAfter = getMethods(clas, After.class);
            testing(object, methodsTest, methodsBefore, methodsAfter);
        }
    }

    private static void testing(Object object, List<Method> methodsTest, List<Method> methodsBefore, List<Method> methodsAfter) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methodsTest) {
            System.out.println("Тестирование: " + method.getName());
            for (Method m : methodsBefore) {
                m.invoke(object);
            }
            method.invoke(object);
            for (Method m : methodsAfter) {
                m.invoke(object);
            }
        }
    }

    private static List<Class> getClasses(String path){
        return new ArrayList<>(new Reflections(path, new SubTypesScanner(false)).getSubTypesOf(Object.class));
    }

    private static List<Method> getMethods(Class clas, Class annotation) {
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : clas.getMethods()) {
            if (!(method.getAnnotation(annotation) == null)) {
                methods.add(method);
            }
        }
        return methods;
    }
}
