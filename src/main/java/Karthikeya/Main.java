package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args){

        Student s1 = new Student();
        s1.setsName("gavrav");
        s1.setRollNo(25);
        s1.setsAge(565);


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Karthikeya.Student.class);
        cfg.configure( );
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();

        session.persist(s1);

        trans.commit();

        System.out.println(s1);


    }
}
