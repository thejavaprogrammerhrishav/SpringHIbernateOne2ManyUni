package com.hdsoft;

import com.hdsoft.config.Config;
import com.hdsoft.dao.Service;
import com.hdsoft.model.Event;
import com.hdsoft.model.User;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext cx = new AnnotationConfigApplicationContext(Config.class);
        //cx.refresh();

        Service dao = cx.getBean(Service.class);

        User u1=new User();
        u1.setName("Hrishav");

        User u2=new User();
        u2.setName("Sagari");

        User u3=new User();
        u3.setName("Ram");

        User u4=new User();
        u4.setName("Debajit");

        User u5=new User();
        u5.setName("Sagari Sen");

        User u6=new User();
        u6.setName("Amaan");

        User u7=new User();
        u7.setName("Priyanka");

        User u8=new User();
        u8.setName("Disha");

        Event e1=new Event();
        e1.setName("Java Programming");
        e1.setUsers(Arrays.asList(u1,u2,u3,u4,u5));

        Event e2=new Event();
        e2.setName("Kotlin Programming");
        e2.setUsers(Arrays.asList(u4,u5,u6,u7));

        Event e3=new Event();
        e3.setName("Android Programming");
        e3.setUsers(Arrays.asList(u1,u2,u7,u8));

        dao.saveEvent(e1);
        dao.saveEvent(e2);
        dao.saveEvent(e3);

        dao.listEvents().forEach(System.out::println);
    }
}
