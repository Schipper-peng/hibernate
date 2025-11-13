package jdbc.relationships.many_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.relationships.many_to_many.entity.University;

public class ManyToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
//            PERSIST
//            University university = new University("Harvard", Date.valueOf("1636-10-28"));
//            Teacher teacher = new Teacher("Alexandro", "Lozano", "CS", true);
//            Teacher teacher1 = new Teacher("Alexandro1", "Lozano1", "CS1", false);
//            Teacher teacher2 = new Teacher("Alexandro2", "Lozano2", "CS2", true);
//
//            university.addTeacherToUniversity(teacher);
//            university.addTeacherToUniversity(teacher1);
//            university.addTeacherToUniversity(teacher2);
//            entityManager.persist(university);
//            Teacher teacher3 = new Teacher("Vera", "Walton", "Geography", true);
//            University university1 = new University("MIT1", Date.valueOf("1861-04-10"));
//            University university2 = new University("MIT2", Date.valueOf("1862-04-10"));
//            University university3 = new University("MIT3", Date.valueOf("1863-04-10"));
//            teacher.addUniversityToTeacher(university1);
//            teacher.addUniversityToTeacher(university2);
//            teacher.addUniversityToTeacher(university3);
//            entityManager.persist(teacher);
//            FIND
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getTeachers());
//            Teacher teacher = entityManager.find(Teacher.class, 3);
//            System.out.println(teacher);
//            System.out.println(teacher.getUniversities());
//            REMOVE
//              Teacher teacher5 = entityManager.find(Teacher.class, 2);
//              University university5 = entityManager.find(University.class, 2);
//              teacher.addUniversityToTeacher(university);
//              entityManager.persist(teacher);
//            Teacher teacher = entityManager.find(Teacher.class,3);
//            entityManager.remove(teacher);
            University university = entityManager.find(University.class, 1);
            entityManager.remove(university);


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
