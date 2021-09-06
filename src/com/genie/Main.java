package com.genie;

import com.genie.other.Son;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // write your code here
/*
        Files.walk(Paths.get("D:\\document")).forEach(System.out::println);
*/
/*        Files.list(Paths.get("D:\\document")).forEach(System.out::println);
        long count = Files.walk(Paths.get("D:\\document\\PDF")).count();
        for (int i = 0; i < count / 100 + 1; i++) {
            getFileStringPageAble(i, 100).forEach(System.out::println);
            System.out.println("----" + i);
        }*/
        /*Son aClass1 =  new Son();*/
        Class<Son> aClass = (Class<Son>) Class.forName("com.genie.other.Son");
        Method sonClass = Son.class.getMethod("method2");
        sonClass.invoke(null);
        //sonClass.invoke(aClass1);
        Constructor constructors = aClass.getConstructor();
        Son o = (Son) constructors.newInstance();
        constructors.setAccessible(true);
        o.method();
    }

    public static List<String> getFileStringPageAble(int start, int pageSize) throws IOException {
        return Files.walk(Paths.get("D:\\document\\PDF"))
                .sorted(Path::compareTo)
                .skip(start * pageSize).limit(pageSize)
                .map(e -> e.toString())
                .collect(Collectors.toList());
    }
}



