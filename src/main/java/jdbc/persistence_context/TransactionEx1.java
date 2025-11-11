package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class TransactionEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher2 = entityManager.find(Teacher.class, 2);
           teacher1.setSubject("CS");

            Teacher teacher3 = entityManager.find(Teacher.class, 3);
            System.out.println(teacher3.isProfessor());

           teacher2.setSubject("MATH");

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
