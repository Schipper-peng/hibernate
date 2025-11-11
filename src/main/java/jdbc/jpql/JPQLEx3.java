package jdbc.jpql;

import jakarta.persistence.*;
import jdbc.jpql.entity.University;

import java.util.List;

public class JPQLEx3 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //Select universities without students
//            Query query = entityManager.createQuery("select u from University u where u.students is empty");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//            ****************************************************************************************************
            //Select universities with 1 student
//            Query query = entityManager.createQuery("select u from University u where size(u.students) = 1");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//            ****************************************************************************************************
            //Sort universities by count of students DESC
//            Query query = entityManager.createQuery("select u from University u order by size(u.students) DESC");
//            List<University> universities = query.getResultList();
//            System.out.println(universities);
//            ****************************************************************************************************
            //CROSS JOIN
//            Query query = entityManager.createQuery("select u, s from University u, Student s");
//            List<Object[]> results = query.getResultList();
//            for(Object[] result: results){
//                System.out.println(result[0] + "-->" + result[1]);
//            }
//            ****************************************************************************************************
            //JOIN
            Query query = entityManager.createQuery("select u, s from University u LEFT JOIN u.students s");
            List<Object[]> results = query.getResultList();
            for(Object[] result: results){
                System.out.println(result[0] + "-->" + result[1]);
            }
//            ****************************************************************************************************


            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
