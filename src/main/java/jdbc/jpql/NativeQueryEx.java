package jdbc.jpql;

import jakarta.persistence.*;
import jdbc.jpql.entity.Student;

import java.util.List;

public class NativeQueryEx {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

//            Query query = entityManager.createNativeQuery("select * from students", Student.class);
//            List <Student> students = query.getResultList();
//            *********************************************************************************
            Query query = entityManager.createNativeQuery("select * from students where avg_grade > ?1 and" +
                    " length(name) = ?2", Student.class);
            query.setParameter(1, 8);
            query.setParameter(2, 5);
            List <Student> students = query.getResultList();
//            *********************************************************************************
            System.out.println(students);




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
