package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("karthu");
        a1.setTech("java");
        a1.setLaptops(Arrays.asList(l1,l2));
        l1.setAlien(a1);
        l2.setAlien(a1);

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
        session.persist(a1);


        trans.commit();

        Alien a2 = session.get(Alien.class,101);
        System.out.println(a2);
        session.close();
        sf.close();



    }
}
