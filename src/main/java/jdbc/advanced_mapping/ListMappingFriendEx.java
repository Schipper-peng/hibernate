package jdbc.advanced_mapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jdbc.advanced_mapping.entity.Employee;
import jdbc.advanced_mapping.entity.Friend;

import java.util.ArrayList;
import java.util.List;

public class ListMappingFriendEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            List<Friend> friendList = new ArrayList<>();
//            Friend friend1 = new Friend("Chanel", "King", 22);
//            Friend friend2 = new Friend("Cha", "Ki", 29);
//            Friend friend3 = new Friend("C", "K", 31);
//            friendList.add(friend1);
//            friendList.add(friend2);
//            friendList.add(friend3);
//
//            Employee employee = new Employee("Michael", 4000, 15d, friendList);
//            entityManager.persist(employee);
            Employee employee = entityManager.find(Employee.class, 1);
            System.out.println(employee);








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
