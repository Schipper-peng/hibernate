package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class EntityStatesEx2 {
     public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            Teacher teacher1 = new Teacher("Oleg", "Sablin", "CS", true);
            Teacher teacher2 = new Teacher("Olga", "Sablina", "RS", false);
            entityManager.persist(teacher1);
            entityManager.persist(teacher2);

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
