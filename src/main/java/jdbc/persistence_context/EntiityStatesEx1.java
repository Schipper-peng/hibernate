package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class EntiityStatesEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            Teacher teacher = new Teacher("Alessandro", "Lozano", "CS", true);
            System.out.println(entityManager.contains(teacher));
            entityManager.persist(teacher);
            System.out.println(entityManager.contains(teacher));
            transaction.commit();
            System.out.println(entityManager.contains(teacher));
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
