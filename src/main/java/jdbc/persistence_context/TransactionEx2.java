package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class TransactionEx2 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            Teacher teacher1 = new Teacher("Landry", "Sheldon", "Economics", true);
            Teacher teacher2 = new Teacher("Landry2", "Sheldon2", "Economics2", true);
            entityManager.persist(teacher1);
            Teacher teacher3 = entityManager.find(Teacher.class, 100);
            System.out.println(teacher3.getName() + " " + teacher3.getSurname());
            entityManager.persist(teacher2);
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
