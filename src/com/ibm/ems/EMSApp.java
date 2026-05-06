package com.ibm.ems;

import com.ibm.ems.service.EmployeeService;
import com.ibm.ems.util.FileUtil;
import com.ibm.ems.util.SalaryProcessor;

import java.util.Scanner;

// Main class
public class EMSApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        
        System.out.println("Loading employee data...");
        FileUtil.loadFromFile(service);

        int choice;

        int i=1;

        do {
            // Display menu
            System.out.println("\n-------- IBM Employee Management System ---------");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Process Salary");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1: // Add Employee
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Type (Permanent / Contract): ");
                    String type = scanner.nextLine();

                    service.addEmployee(id, name, salary, type);
                    break;

                case 2: // View Employees
                    service.viewAllEmployees();
                    break;

                case 3: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        service.updateEmployee(updateId, newName, newSalary);
                    } catch (Exception e) {
                        System.out.println("Wrong " + e.getMessage());
                    }
                    break;

                case 4: // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        service.deleteEmployee(deleteId);
                    } catch (Exception e) {
                        System.out.println("Wrong " + e.getMessage());
                    }
                    break;

                case 5: // Search Employee
                    System.out.println("Search by: 1. ID   2. Name");
                    System.out.print("Enter choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (searchChoice == 1) {
                        System.out.print("Enter Employee ID: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();
                        service.searchById(searchId);
                    } else {
                        System.out.print("Enter Employee Name: ");
                        String searchName = scanner.nextLine();
                        service.searchByName(searchName);
                    }
                    break;

                case 6: // Process Salary (Multithreaded)
                    SalaryProcessor.processSalaryWithThreads(service);
                    break;

                case 7: // Save Data
                    FileUtil.saveToFile(service.getAllEmployees());
                    break;

                case 8: // Exit
                    System.out.println(" Auto-saving before exit...");
                    FileUtil.saveToFile(service.getAllEmployees());
                    System.out.println("Goodbye! Thank you for using IBM EMS.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-8.");
            }

        } while (choice != 8);

        scanner.close();
    }
}