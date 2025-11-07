package jdbc.example.relationships.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.example.relationships.one_to_many.entity.Student;
import jdbc.example.relationships.one_to_many.entity.University;

import java.sql.Date;

public class OneToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//            PERSIST
//            University university = new University("MIT", Date.valueOf("1864-12-22"));
//            Student student1 = new Student("Lesli", "Nicolson", 9.1);
//            Student student2 = new Student("Oleg", "Bogdanov", 8.3);
//            Student student3 = new Student("Lesli", "Nicolson", 9.1);
//            Student student4 = new Student("Oleg", "Bogdanov", 8.3);
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//            university.addStudentToUniversity(student3);
//            university.addStudentToUniversity(student4);
//            entityManager.persist(university);
//            Student student3 = new Student("Ivan", "Urgant", 7.3);
//            Student student4 = new Student("Tanya", "Melnik", 8.7);
//            University university = new University("Oxford", Date.valueOf("1200-09-01"));
//            university.addStudentToUniversity(student3);
//            university.addStudentToUniversity(student4);
//            entityManager.persist(student3);
//            FIND
            University university = entityManager.find(University.class, 1);
            System.out.println(university);
            System.out.println(university.getStudents());
//            REMOVE
//            Student student = entityManager.find(Student.class, 1);
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
