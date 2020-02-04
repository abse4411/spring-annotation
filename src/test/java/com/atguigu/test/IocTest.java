package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MyConfiguration;
import com.atguigu.config.MyConfiguration1;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.Objects;

public class IocTest {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MyConfiguration1.class);
    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        System.out.println("printBeans:================");
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println("printBeans:================");
    }
    @Test
    public void testGetBeanDefinitionNames(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);
        String[] names = context.getBeanDefinitionNames();
        for(String name : names)
            System.out.println(name);
    }

    @Test
    public void testBeanScope(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);
        Object person1 = context.getBean("myPerson");
        Object person2 = context.getBean("myPerson");
        Assert.assertTrue(Objects.equals(person1, person2));

        context =
                new AnnotationConfigApplicationContext(MyConfiguration1.class);
        person1 = context.getBean("myPerson");
        person2 = context.getBean("myPerson");
        Assert.assertFalse(Objects.equals(person1, person2));
    }

    @Test
    public void testLazy(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration1.class);
        System.out.println("AnnotationConfigApplicationContext Created");
        Object person1 = context.getBean("myPerson");
        System.out.println(person1);
        person1 = context.getBean("myPerson");
        System.out.println(person1);

    }



    @Test
    public void testConditional(){
        String[] namesForType = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = context.getBeansOfType(Person.class);
        System.out.println(persons);

    }

    @Test
    public void testImport(){
        String[] namesForType = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();


    }

}
