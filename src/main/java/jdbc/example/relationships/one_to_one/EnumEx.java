package jdbc.example.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.example.relationships.one_to_one.entity.Passport;
import jdbc.example.relationships.one_to_one.entity.Student;

public class EnumEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Student student = new Student("John", "Scott", 9.1);
//            Passport passport = new Passport("johny@mail.ru", 175, EyeColor.BLUE);
//            student.setPassport(passport);
//            entityManager.persist(student);
            Student student = entityManager.find(Student.class, 1);
            System.out.println(student.getPassport());

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
