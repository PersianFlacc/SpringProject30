package org.example.project30;

import org.example.project30.Entity.Department;
import org.example.project30.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

//            session = factory.getCurrentSession();
//
//            Department department = new Department("IT", 2000, 500);
//            Employee emp1 = new Employee("Igor", "Zubov", 1000);
//            Employee emp2 = new Employee("Ekaterina", "Chernyh", 1500);
//            Employee emp3 = new Employee("Pavel", "Morozov", 2000);
//
//            department.setEmployeeToDepartment(emp1);
//            department.setEmployeeToDepartment(emp2);
//            department.setEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//
//            session.persist(department);
//
//            session.getTransaction().commit();
//
//            System.out.println("Успешно!");

            //////////////////////////////////

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department...");
            Department department = session.get(Department.class, 1);
            System.out.println("Show department:");
            System.out.println(department);
            System.out.println("Show employees of the department:");
            System.out.println(department.getEmps());

            session.getTransaction().commit();

            System.out.println("Успешно!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
