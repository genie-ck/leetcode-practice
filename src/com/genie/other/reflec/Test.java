package com.genie.other.reflec;

import com.genie.other.Son;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //获取Class对象的三个方法
        //1 对象的getClass()
        //2 类的class 属性
        //3 Class.forName("")
        //getX      获取本类及父类的public的X
        //getDeclared  获取本类的所有X
        Son son = new Son(1);
        Class<? extends Son> aClass = son.getClass();
        Class<Son> sonClass = Son.class;
        Class<?> aClass1 = Class.forName("com.genie.other.Son");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].toString());
        }
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor a :
                declaredConstructors) {
            System.out.println(a.toString());
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method a :
                declaredMethods) {

            System.out.println(a);
        }
        //执行方法
        //如果是静态的方法，可以不传对象
        Method method = sonClass.getMethod("method3", String.class);
        method.invoke(son, "aa");
        Method method2 = aClass1.getDeclaredMethod("method2");
        method2.invoke(null);
        // 创建对象的两种
        // clazz.newInstance(); 如果没有默认构造器会报错
        // clazz.getConstructor() 根据传参来判断是哪个构造器
        Son son1 = aClass.newInstance();
        Constructor<? extends Son> constructor = aClass.getConstructor(int.class);
        Son son2 = constructor.newInstance(1);
        System.out.println(son1);
        System.out.println(son2);

    }
}
