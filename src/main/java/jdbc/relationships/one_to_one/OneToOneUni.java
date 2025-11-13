package jdbc.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.relationships.one_to_one.entity.Passport;
import jdbc.relationships.one_to_one.entity.Student;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Student student1 = new Student("Oleg", "Sablin", 6.3 );
            Passport passport1 = new Passport("sablin@mail.com", 185, EyeColor.BLUE);
            student1.setPassport(passport1);

            entityManager.persist(passport1);
            entityManager.persist(student1);
//            Student student = entityManager.find(Student.class, 3);
//            System.out.println(student);
//            System.out.println(student.getPassport());
//            Student student = entityManager.find(Student.class, 3);
//            entityManager.remove(student);


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
