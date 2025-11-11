package jdbc.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jdbc.criteria_query.entity.Student;

import java.util.List;

public class CriteriaQueryEx1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            //JPQL: select s from Student;\
            //1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            //2 Creation of Criteria Query
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
            //3 Root creation
            Root<Student> root = criteriaQuery.from(Student.class);//from Student s
            //4 Adding rot to Criteria Query
            criteriaQuery.select(root); // select s from Student s
            //5 Query creation
            TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
            List<Student> students = query.getResultList();
            System.out.println(students);
            Query query100 = entityManager.createQuery("select s from Student");

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
