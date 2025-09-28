package iuh.fit.se.beans;

import iuh.fit.se.beans.autowiring.Department;
import iuh.fit.se.beans.javabased.Group;
import iuh.fit.se.beans.javabased.User;
import iuh.fit.se.beans.javabased.UserService;
import iuh.fit.se.beans.xmlbased.bai1.Student1;
import iuh.fit.se.beans.xmlbased.bai2.Class_;
import iuh.fit.se.beans.xmlbased.bai2.Student2;
import iuh.fit.se.beans.xmlbased.bai3.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context, contextJava;

    public static void main(String[] args) {
        // slide 28
//        context = new ClassPathXmlApplicationContext("beans.xml");
//        System.out.println("Bai 1");
//        Student1 student1 = context.getBean("student1", Student1.class);
//        System.out.println(student1);

        // slide 29, 30
//        System.out.println("\nBai 2");
//        Student2 student2 = context.getBean("student2", Student2.class);
//        Student2 student3 = context.getBean("student3", Student2.class);
//        System.out.println(student2);
//        System.out.println(student3);

        //slide 31
//        System.out.println("\nBai 3");
//        Person person= context.getBean("person", Person.class);
//        System.out.println(person);

        //slide 32
//        System.out.println("\nBai 4");
//        Class_ class_= context.getBean("class2", Class_.class);
//        System.out.println(class_);

        //slide 33-36
//        System.out.println("\nBai 5 Spring's AutoWiring");
//        Department dept1= context.getBean("dept1", Department.class);
//        System.out.println(dept1);
//
//        Department dept2= context.getBean("dept2", Department.class);
//        System.out.println(dept2);

        //java - based
        contextJava = new AnnotationConfigApplicationContext(UserService.class);
        User user= contextJava.getBean(User.class);
        System.out.println(user);

        Group group = contextJava.getBean(Group.class);
        System.out.println(group);


    }
}
