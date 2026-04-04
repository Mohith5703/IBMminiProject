package com.ibm.ems.util;

import com.ibm.ems.model.ContractEmployee;
import com.ibm.ems.model.Employee;
import com.ibm.ems.model.PermanentEmployee;
import com.ibm.ems.service.EmployeeService;

import java.io.*;
import java.util.List;

// File Utility - Save and Load employees from file
public class FileUtil {

    private static final String FILE_NAME = "employees.txt";


    // 9. Save to file

    public static void saveToFile(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Employee emp : employees) {
                // Format: id,name,salary,type
                writer.write(emp.toFileString());
                writer.newLine(); // new line for each employee
            }

            System.out.println("Data saved to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }


    // 9.Load from file

    public static void loadFromFile(EmployeeService service) {
        File file = new File(FILE_NAME);

        // If file doesn't exist yet, skip loading
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            service.clearAll(); // Clear existing list before loading

            while ((line = reader.readLine()) != null) {
                // Split each line by comma
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    int id         = Integer.parseInt(parts[0].trim());
                    String name    = parts[1].trim();
                    double salary  = Double.parseDouble(parts[2].trim());
                    String type    = parts[3].trim();

                    Employee emp;
                    if (type.equalsIgnoreCase("Permanent")) {
                        emp = new PermanentEmployee(id, name, salary);
                    } else {
                        emp = new ContractEmployee(id, name, salary);
                    }

                    service.addEmployee(emp);
                }
            }

            System.out.println("Data loaded from " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}