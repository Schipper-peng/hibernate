package jdbc.jpql;

import jakarta.persistence.*;
import jdbc.jpql.entity.Student;

import java.util.List;

public class JPQLEx2 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //ALL STUDENTS with 'L' in name and avg grade > 8.5 position parameters
//            Query query = entityManager.createQuery("Select s from Student s" +
//                    " where s.name LIKE ?1 AND s.avgGrade > ?2");
//            query.setParameter(1, "%l%");
//            query.setParameter(2, 8.5);
//            List <Student> students = query.getResultList();
//            ******************************************************************************************************
            //ALL STUDENTS with 'L' in name and avg grade > 8.5 named parameters
//            Query query = entityManager.createQuery("Select s from Student s" +
//                    " where s.name LIKE :letter AND s.avgGrade > :grade ");
//            query.setParameter("letter", "%l%");
//            query.setParameter("grade", 8.5);
//            List <Student> students = query.getResultList();
//            ******************************************************************************************************
            //UPDATE
//            Query query = entityManager.createQuery("update Student s set avgGrade = 7.0 " +
//                    " where length(surname) > 6 ");
//            query.executeUpdate();
//            ******************************************************************************************************
            //DELETE
            Query query = entityManager.createQuery("delete Student s where s.avgGrade < 7.5 OR s.avgGrade IS NULL ");
            query.executeUpdate();
//            ******************************************************************************************************

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
