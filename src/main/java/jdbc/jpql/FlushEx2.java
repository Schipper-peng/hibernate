package jdbc.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.jpql.entity.Student;
import jdbc.persistence_context.entity.Teacher;

public class FlushEx2 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            Student student = entityManager.find(Student.class, 1);
            student.setAvgGrade(9.0);

            Double avgGrade = (Double)entityManager.createQuery("select s.avgGrade from Student s where s.id=1")
                    .getSingleResult();
            System.out.println(avgGrade);



            transaction.commit();
        } catch (Exception e) {
            if(transaction !=null) {
                System.out.println("ROLLBACK");
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
