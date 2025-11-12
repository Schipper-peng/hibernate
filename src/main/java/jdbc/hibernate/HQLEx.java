package jdbc.hibernate;

import jdbc.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLEx {
    public static void main (String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();

//            ALL Students
//             select * from students
//            Query <Student> query = session.createQuery("from Student ");
//            List<Student> students = query.getResultList();
//
//            for(Student st: students) {
//                System.out.println(st);
//            }
//            *********************************************************************
//            ALL Students where name with 'l' or 'L' and grade > 8
//            List<Student> students = session.createQuery("from Student s where lower(s.name) like '%l%' " +
//                    "and avgGrade > 8").
//                    getResultList();
//
//            for(Student st: students) {
//                System.out.println(st);
//            }
//            *********************************************************************
            //            UPDATE
//            session.createQuery("update Student set avgGrade = 10.0 where length(name)=5 ").executeUpdate();

//            *********************************************************************
            //            DELETE
            session.createQuery("delete Student where avgGrade < 9 ").executeUpdate();

//            *********************************************************************




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
