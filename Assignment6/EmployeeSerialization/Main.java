package EmployeeSerialization;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Creating employee objects
            Employee e1 = new Employee(101, "Anshika", "IT", 50000);
            Employee e2 = new Employee(102, "Rahul", "HR", 45000);
            Employee e3 = new Employee(103, "Priya", "Finance", 55000);

            // Serialization
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("employee.txt"));

            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(e3);
            out.close();

            System.out.println("Employee records saved successfully!");

            // Deserialization
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.txt"));

            System.out.println("\nEmployee Records:");

            Employee emp;
            for (int i = 0; i < 3; i++) {
                emp = (Employee) in.readObject();
                emp.display();
            }

            in.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
