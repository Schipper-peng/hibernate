package jdbc.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class DetachedEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Teacher teacher = entityManager.find(Teacher.class, 1);
            System.out.println(entityManager.contains(teacher));
            entityManager.detach(teacher);
            System.out.println(entityManager.contains(teacher));
            teacher.setSubject("DOTA");


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
