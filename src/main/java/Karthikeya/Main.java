package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

import java.util.Arrays;


public class Main {
    public static void main(String[] args){
        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("HP");
        l1.setModel("Victus");
        l1.setRam(32);




        SessionFactory sf = new Configuration()
       /*  Here you need to use the class what you need for the manuplating */
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        //SELECT * FROM Laptop where ram = 32 --> SQL
        // from laptop where ram  32 -->HQL


        Query query = session.createQuery("from Laptop where ram=32",Laptop.class);
        List<Laptop> laptops = query.getResultList();

        //Laptop l5 = session.find(Laptop.class,3);
        System.out.println(laptops);

        session.close();

        sf.close();



    }
}
