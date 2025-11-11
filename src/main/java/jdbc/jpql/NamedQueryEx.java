package jdbc.jpql;

import jakarta.persistence.*;
import jdbc.jpql.entity.Student;
import jdbc.jpql.entity.University;

import java.util.List;

public class NamedQueryEx {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {


//            Query query = entityManager.createNamedQuery("University.allUniversitiesLessOrEqualTo2");
//            List<University>universities = query.getResultList();
//            System.out.println(universities);
            Query query = entityManager.createNamedQuery("University.studentsWithAvgGradeBetween");
            query.setParameter("from", 6);
            query.setParameter("to", 8);
            List<Student> students = query.getResultList();
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
