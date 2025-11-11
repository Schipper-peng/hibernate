package jdbc.persistence_context.jpa_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class FlushEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
//            Teacher teacher1 = new Teacher("Coby", "Briant", "Basketball", false);
//            Teacher teacher2 = new Teacher("Woody", "Woodpeccer", "Wooding", true);
//            Teacher teacher3 = new Teacher("Scooby", "Doo", "Woowing", false);
//            entityManager.persist(teacher1);
//            entityManager.persist(teacher2);
//            entityManager.persist(teacher3);
            Teacher teacher1 = entityManager.find(Teacher.class, 1);
            Teacher teacher2 = entityManager.find(Teacher.class, 2);
            Teacher teacher3 = entityManager.find(Teacher.class, 3);
            System.out.println("UPDATE teacher 1");
            teacher1.setSubject("Economycs");
            System.out.println("DELETE teacher 2");
            entityManager.remove(teacher2);
            System.out.println("FLUSH");
            entityManager.flush();
            System.out.println("UPDATE teacher 3");
            teacher3.setProfessor(true);
            System.out.println("COMMIT");
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
