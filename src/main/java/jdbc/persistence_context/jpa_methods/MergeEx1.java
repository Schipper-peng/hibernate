package jdbc.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class MergeEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher1 = new Teacher("Coby", "Briant", "Basketball", false);
            entityManager.persist(teacher1);


            transaction.commit();
            entityManager.close();
            //----------------------------------------------------------------------------------
            teacher1.setSubject("MATH");
            entityManager = factory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

//            entityManager.persist(teacher1);
            Teacher mergedTeacher = entityManager.merge(teacher1);


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
