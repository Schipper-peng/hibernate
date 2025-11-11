package jdbc.jpql;

import jakarta.persistence.*;
import jdbc.jpql.entity.Student;

import java.util.List;

public class JPQLEx1 {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            //ALL STUDENTS
            //select * from students;
//            TypedQuery <Student> query = entityManager.createQuery("select s from Student s", Student.class);
//            List <Student> students = query.getResultList();
//            List<Student> students = entityManager.createQuery("Select s from Student s").getResultList();
//            ******************************************************************************************************
            //ALL students with name Leo
//            List<Student> students = entityManager.createQuery("select s from Student s where s.name = 'Leo' ")
//                    .getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students with avg_grade>8.5
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where avgGrade > 8.5").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students with afg_grade between 7 and 8
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where avgGrade between 7 and 8").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students with "a" in name
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where s.name LIKE '%a%'").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students with "a" or 'A' in name
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where lower(s.name) LIKE '%a%'").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students without avg grade
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where s.avgGrade IS NULL").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL students with 'l' in name and avg_grade > 8.5
//            List<Student> students = entityManager.createQuery("select s from Student s" +
//                    " where s.name LIKE '%l%' AND s.avgGrade > 8.5 ").getResultList();
//            System.out.println(students);
//            ******************************************************************************************************
            //ALL Students names
//            List<String> names = entityManager.createQuery("select s.name from Student s").getResultList();
//            System.out.println(names);
//            ******************************************************************************************************
            //ALL Students names and avgGrade
//            List<Object[]> studentsInfo = entityManager.createQuery("select s.name, s.avgGrade from Student s").getResultList();
//            Object[0] - name
//            Object[1] - avgGrade
//            for(Object[] info: studentsInfo){
//                System.out.println(info[0] + "-->" + info[1]);
//            }
//            ******************************************************************************************************
            //MAX avgGrade
//            Query query = entityManager.createQuery("select max(s.avgGrade) from Student s");
//            double maxGrade = (Double)query.getSingleResult();
//            System.out.println(maxGrade);
//            ******************************************************************************************************
            //AVERAGE of avgGrade
            Query query = entityManager.createQuery("select avg(s.avgGrade) from Student s");
            double avgGrade = (Double)query.getSingleResult();
            System.out.println(avgGrade);




            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
