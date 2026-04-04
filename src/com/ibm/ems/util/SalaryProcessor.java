package com.ibm.ems.util;

import com.ibm.ems.model.Employee;
import com.ibm.ems.service.EmployeeService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 10. Multithreading - Process salary using threads
public class SalaryProcessor {

    // Each employee salary is processed in a separate thread
    public static void processSalaryWithThreads(EmployeeService service) {

        List<Employee> employees = service.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees to process.");
            return;
        }

        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("\n------ Salary Processing (Multithreaded) ----------");

        for (Employee emp : employees) {
            // Each employee salary is processed in a Runnable thread
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    double salary = emp.calculateSalary();
                    System.out.println("[Thread: " + Thread.currentThread().getName() + "]"
                            + " Name: " + emp.getName()
                            + " | Final Salary: " + salary);
                }
            };

            executor.execute(task); // Submit task to thread pool
        }

        executor.shutdown(); // Stop accepting new tasks

        // Wait for all threads to finish
        while (!executor.isTerminated()) {
            // waiting...
        }

        System.out.println("=============================================\n");
    }
}