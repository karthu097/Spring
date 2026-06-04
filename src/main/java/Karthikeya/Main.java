package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {
    public static void main(String[] args){

        Student s1 = new Student();
        s1.setsName("gavr"); //dulicates are not allowed in the database

        s1.setRollNo(2);
        s1.setsAge(5555);

        Student s2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Karthikeya.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        //session.persist(s1);
    s2 = session.get(Student.class,101);
        session.close();
        sf.close();

        System.out.println(s1);


    }
}
