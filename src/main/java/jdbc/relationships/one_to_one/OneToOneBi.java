package jdbc.relationships.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.relationships.one_to_one.entity.Passport;

public class OneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//              PERSIST
//            Student student = new Student("Ivan", "Sharapov", 8.3 );
//            Passport passport = new Passport("sharapov@mail.com", 194, "brown");
//
//            passport.setStudent(student);
//            student.setPassport(passport);
//            entityManager.persist(passport);

            //            FIND
//            Passport passport = entityManager.find(Passport.class, 2);
//            System.out.println(passport);
//            System.out.println(passport.getStudent());
//            REMOVE
//            Passport passport = entityManager.find(Passport.class, 2);
//            entityManager.remove(passport);
            Passport passport = entityManager.find(Passport.class, 3);
            passport.getStudent().setPassport(null);
            entityManager.remove(passport);



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
