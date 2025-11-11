package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class FirstLvlCacheEx {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            entityManager.close();
//            transaction.commit();
//            transaction.begin();
            entityManager = factory.createEntityManager();
            Teacher teacher2 = entityManager.find(Teacher.class, 1);
            transaction.commit();


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
