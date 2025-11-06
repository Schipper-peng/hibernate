package jdbc.example.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.example.relationships.one_to_one.entity.Passport;
import jdbc.example.relationships.one_to_one.entity.Student;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//            PERSIST

//            Student student1 = new Student("Ivan", "Sharapov", 8.3 );
//            Passport passport1 = new Passport("sharapov@mail.com", 194, "brown");
//            student1.setPassport(passport1);
//
//            entityManager.persist(passport1);
//            entityManager.persist(student1);
//            Student student = entityManager.find(Student.class, 3);
//            System.out.println(student);
//            System.out.println(student.getPassport());
            Student student = entityManager.find(Student.class, 3);
            entityManager.remove(student);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

    }
}
