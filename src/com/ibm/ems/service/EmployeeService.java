package com.ibm.ems.service;

import com.ibm.ems.exception.EmployeeNotFoundException;
import com.ibm.ems.model.ContractEmployee;
import com.ibm.ems.model.Employee;
import com.ibm.ems.model.PermanentEmployee;

import java.util.ArrayList;
import java.util.List;

// Service class - handles all CRUD operations
public class EmployeeService {

    // ArrayList to store all employees
    private List<Employee> employeeList = new ArrayList<>();

    // -------------------------
    // FR-01: Add Employee
    // -------------------------
    public void addEmployee(int id, String name, double salary, String type) {
        Employee emp;

        if (type.equalsIgnoreCase("Permanent")) {
            emp = new PermanentEmployee(id, name, salary);
        } else {
            emp = new ContractEmployee(id, name, salary);
        }

        employeeList.add(emp);
        System.out.println("✅ Employee added successfully: " + name);
    }

    // Also supports adding directly (used by FileUtil on load)
    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    // -------------------------
    // FR-02: View All Employees
    // -------------------------
    public void viewAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠ No employees found.");
            return;
        }

        System.out.println("\n===== Employee List =====");
        for (Employee emp : employeeList) {
            emp.display();
        }
        System.out.println("=========================\n");
    }

    // -------------------------
    // FR-03: Update Employee
    // -------------------------
    public void updateEmployee(int id, String newName, double newSalary)
            throws EmployeeNotFoundException {

        Employee emp = findById(id); // throws exception if not found
        emp.setName(newName);
        emp.setSalary(newSalary);
        System.out.println("Employee updated successfully.");
    }

    // -------------------------
    // FR-04: Delete Employee
    // -------------------------
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee emp = findById(id); // throws exception if not found
        employeeList.remove(emp);
        System.out.println("✅ Employee deleted successfully.");
    }

    // -------------------------
    // FR-07: Search Employee
    // -------------------------
    public void searchById(int id) {
        try {
            Employee emp = findById(id);
            System.out.println("\n===== Search Result =====");
            emp.display();
            System.out.println("=========================\n");
        } catch (EmployeeNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        System.out.println("\n===== Search Results =====");

        for (Employee emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                emp.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employee found with name: " + name);
        }
        System.out.println("==========================\n");
    }

    // -------------------------
    // FR-06: Salary Calculation (display)
    // -------------------------
    public void processSalary() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to process.");
            return;
        }

        System.out.println("\n===== Salary Processing ");
        for (Employee emp : employeeList) {
            System.out.println("Name: " + emp.getName() +
                    " | Calculated Salary: " + emp.calculateSalary());
        }
        System.out.println("------------------\n");
    }

    // -------------------------
    // Helper: Find by ID
    // -------------------------
    private Employee findById(int id) throws EmployeeNotFoundException {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        // If not found, throw custom exception
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found!");
    }

    // Get full list (used by FileUtil to save)
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Clear list (used before loading from file)
    public void clearAll() {
        employeeList.clear();
    }
}