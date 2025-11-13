package jdbc.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.advanced_mapping.entity.Address;
import jdbc.advanced_mapping.entity.Employee;

import java.util.ArrayList;
import java.util.List;

//public class ListMappingStringEx {
//    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("jpa-course");
//        EntityManager entityManager = factory.createEntityManager();
//
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//
//            List<String> friendsNames = new ArrayList<>();
//            friendsNames.add("Roy");
//            friendsNames.add("Erick");
//            friendsNames.add("Roman");
//
//            Employee employee = new Employee("Rudolf", 2500, 10d, friendsNames);
//            entityManager.persist(employee);
////            Employee employee = entityManager.find(Employee.class, 2);
////            System.out.println(employee);
//
//
//
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            if (entityManager != null) {
//                entityManager.close();
//                factory.close();
//            }
//        }
//
//    }
//
//}
