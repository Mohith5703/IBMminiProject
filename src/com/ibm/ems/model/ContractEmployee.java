package com.ibm.ems.model;

// Contract Employee - no bonus
public class ContractEmployee extends Employee {

    // Constructor
    public ContractEmployee(int id, String name, double salary) {
        super(id, name, salary, "Contract");
    }

    // Override: Contract employee gets no bonus
    @Override
    public double calculateSalary() {
        return getSalary(); // No bonus
    }

    // Override display
    @Override
    public void display() {
        System.out.println("ID: " + getId() +
                " | Name: " + getName() +
                " | Salary: " + getSalary() +
                " | No Bonus" +
                " | Type: Contract");
    }
}