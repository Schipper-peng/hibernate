package jdbc.criteria_query;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import jdbc.criteria_query.entity.Student;
import jdbc.criteria_query.entity.University;

import java.util.List;

public class CriteriaQueryEx3 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            *******************************************************************************************************
            //            JPQL: select s.name and s.avgGrade     from Student s
//            1 Creation of Criteria Builder
//            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            2 Creation of Criteria Query
//            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//            3 Root creation
//            Root<Student> root = criteriaQuery.from(Student.class);//from Student s
//            4 Adding rot to Criteria Query
//            criteriaQuery.multiselect(root.get("name"), root.get("avgGrade")); // select s.name. s.avgGrade from Student s
//            5 Query creation
//            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
//            List<Object[]> studentInfo = query.getResultList();
//            for(Object[] info : studentInfo) {
//                System.out.println(info[0] + " " + info[1]);
//            }
//            *******************************************************************************************************
            //            JPQL: select u, s from University u JOIN u.student s;
//            1 Creation of Criteria Builder
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//            2 Creation of Criteria Query
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//            3 Root creation
            Root<University> root = criteriaQuery.from(University.class);//from University u
//            3.1 JOIN
            Join<University, Student> join = root.join("students");
//            4 Adding root to Criteria Query
            criteriaQuery.multiselect(root, join); // select u, s from University u JOIN // u.students s
//            5 Query creation
            TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
            List<Object[]> students = query.getResultList();
            for(Object[] info : students) {
                System.out.println(info[0] + "-->" + info[1]);
            }
//            *******************************************************************************************************



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
