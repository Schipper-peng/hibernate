package jdbc.hibernate;

import jdbc.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateEx3 {
    public static void main (String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();

            Student student1 = session.get(Student.class, 2);
            student1.setAvgGrade(9.0);
            System.out.println("Average grade was updated");

            System.out.println(student1);



            transaction.commit();
        }
        catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}
