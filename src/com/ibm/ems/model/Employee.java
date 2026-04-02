package com.ibm.ems.model;

// Base class for all employees
public class Employee {

    // Fields (Encapsulation)
    private int id;
    private String name;
    private double salary;
    private String type; // "Permanent" or "Contract"

    // Constructor
    public Employee(int id, String name, double salary, String type) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getType() { return type; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }

    // Method to calculate salary - will be overridden by subclasses
    public double calculateSalary() {
        return salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name +
                " | Salary: " + salary + " | Type: " + type);
    }

    // Convert to file-saveable string
    public String toFileString() {
        return id + "," + name + "," + salary + "," + type;
    }
}