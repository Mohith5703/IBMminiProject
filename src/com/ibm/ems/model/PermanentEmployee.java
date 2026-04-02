package com.ibm.ems.model;

// Permanent Employee gets 10% bonus
public class PermanentEmployee extends Employee {

    // Constructor
    public PermanentEmployee(int id, String name, double salary) {
        super(id, name, salary, "Permanent");
    }

    // Override: Permanent employee gets 10% bonus
    @Override
    public double calculateSalary() {
        double bonus = getSalary() * 0.10;
        return getSalary() + bonus;
    }

    // Override display to show bonus info
    @Override
    public void display() {
        System.out.println("ID: " + getId() +
                " | Name: " + getName() +
                " | Base Salary: " + getSalary() +
                " | Total (with 10% bonus): " + calculateSalary() +
                " | Type: Permanent");
    }
}