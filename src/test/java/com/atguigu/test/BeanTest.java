package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MyConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Test
    public void PersonTest1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void PersonTest2(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }
}
