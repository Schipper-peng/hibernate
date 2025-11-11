package jdbc.persistence_context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.persistence_context.entity.Teacher;

public class SecondLvlCacheEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");

        try {
            EntityManager entityManager1 = factory.createEntityManager();
            System.out.println("First time");
            Teacher teacher1 = entityManager1.find(Teacher.class, 1);
            System.out.println(teacher1);
            entityManager1.close();

            EntityManager entityManager2 = factory.createEntityManager();
            System.out.println("Second time");
            Teacher teacher2 = entityManager2.find(Teacher.class, 1);
            System.out.println(teacher2);
            entityManager2.close();


        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
