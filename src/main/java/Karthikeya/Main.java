package Karthikeya;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        String brand = "HP";

        Query<Object[]> query = session.createQuery(
                "select brand, model from Laptop where brand = :brand",
                Object[].class
        );

        query.setParameter("brand", brand);

        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops) {
            String laptopBrand = (String) data[0];
            String model = (String) data[1];

            System.out.println("Brand: " + laptopBrand +
                    ", Model: " + model);
        }

        session.close();
        sf.close();
    }
}