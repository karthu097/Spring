package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args){
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("lenovo");
        l1.setModel("LOQ");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("lenovos");
        l2.setModel("LOtQ");
        l2.setRam(146);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Dell");
        l3.setModel("Alien X");
        l3.setRam(15);


        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("karthu");
        a1.setTech("java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Ravi");
        a2.setTech("Python");

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3));



        SessionFactory sf = new Configuration()
       /*  Here you need to use the class what you need for the manuplating */
                .addAnnotatedClass(Karthikeya.Alien.class)
                .addAnnotatedClass(Karthikeya.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction trans = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);



        trans.commit();




        session.close();

        Session session1 = sf.openSession();
        Alien a5 = session1.find(Alien.class,101);// get() method haves been deprecated in 7.1.0 but not removed

        //System.out.println(a5);
        // if you are not using print statement also the output executes

        session1.close();
        sf.close();



    }
}
