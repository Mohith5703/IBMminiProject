# IBM Employee Management System (EMS)
## Capsule Project (Core Java)

---

## 📌 Project Overview

This is a **mini Employee Management System (EMS)** to be built using **Core Java (console-based)**.

- 👥 Team Size: 4–5 members  
- ⏱ Duration: 3–4 hours  
- 🎯 Goal: Apply Core Java concepts in a **simple, working application**

---

## 👥 Teams

### Team 1
- Bala, Sandesh
- Reddy, Dhoddi Mallikarjuna
- VP, Rahees Ahammed
- S, Mohith
- Darshan, B S

### Team 2
- S N, Akul
- B M, Poorvika
- Dama, Pavan
- Govardhan, Majjiga
- Vamsikrishna, Valluri

### Team 3
- Kottam, Gnaneswar
- Prasad M T, Saketh
- Raju, Vishnu
- C D, Nisha
- PERAM, Tarun Kumar Reddy

### Team 4
- Mogaveera, Nayan
- SAIBHARATH, K
- Kumar, MuppalaMuppala Anil
- Krishnamanikanta
- Saji, Amal

---

## 🎯 Objective

Build a **menu-driven console application** that can:

- Add employees
- View employees
- Update employee details
- Delete employees
- Process salary
- Save & load data from file

---

## ⚙️ Features (Simplified)

### ✅ FR-01: Add Employee
- Fields:
  - ID
  - Name
  - Salary
  - Type (Permanent / Contract)

✔ Concepts:
- Classes & Objects
- Encapsulation
- Constructors

---

### ✅ FR-02: View All Employees

✔ Concepts:
- Collections (`ArrayList`)
- Loops

---

### ✅ FR-03: Update Employee

✔ Concepts:
- Object manipulation
- Condition checking

---

### ✅ FR-04: Delete Employee

✔ Concepts:
- Collection removal

---

### ✅ FR-05: Employee Types (Polymorphism)

- Permanent → Bonus applicable  
- Contract → No bonus  

✔ Concepts:
- Inheritance
- Method overriding

---

### ✅ FR-06: Salary Calculation

Simple logic:

- Permanent:
  - Bonus = 10%
- Contract:
  - No bonus

✔ Concepts:
- Polymorphism
- Method overriding

---

### ✅ FR-07: Search Employee

Search by:
- ID
- Name

✔ Concepts:
- Streams (basic filter)
OR
- Loop-based search

---

### ✅ FR-08: Exception Handling

- If employee not found → throw custom exception

✔ Concepts:
- Custom Exception
- try-catch

---

### ✅ FR-09: File Save & Load

- Save employees to file (`employees.txt`)
- Load on startup

✔ Concepts:
- File I/O
- BufferedReader / BufferedWriter

---

### ✅ FR-10: Multithreading (Basic)

- Process salary for all employees using threads

✔ Concepts:
- Runnable / ExecutorService

---

## 🧱 Suggested Structure

com.ibm.ems
│
├── model
│   ├── Employee.java
│   ├── PermanentEmployee.java
│   ├── ContractEmployee.java
│
├── service
│   ├── EmployeeService.java
│
├── util
│   ├── FileUtil.java
│
├── main
│   ├── EMSApp.java

---

## 🧑‍🤝‍🧑 Team Responsibilities

| Role | Responsibility |
|------|----------------|
| Member 1 | Model classes |
| Member 2 | Service (CRUD) |
| Member 3 | Salary + Threads |
| Member 4 | File I/O |
| Member 5 | Main menu + integration |

---

## 📋 Menu Example

1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Search Employee
6. Process Salary
7. Save Data
8. Exit

---

## 🧪 Demo Scenarios

### ✅ Scenario 1
Add 3 employees → Display list

### ✅ Scenario 2
Update salary → Verify change

### ✅ Scenario 3
Delete employee → Verify removal

### ✅ Scenario 4
Search employee → Show result

### ✅ Scenario 5
Run salary processing → Show output

### ✅ Scenario 6
Save → Restart → Load data

---

## 📊 Evaluation Criteria

| Criteria | Marks |
|----------|------|
| OOP Concepts | 30 |
| Collections | 15 |
| Exception Handling | 10 |
| File I/O | 15 |
| Multithreading | 10 |
| Code Quality | 10 |
| Demo | 10 |

---

## ⏱ Suggested Timeline

| Time | Task |
|------|------|
| 0–30 min | Setup + design |
| 30–120 min | Coding |
| 120–180 min | Integration |
| 180–210 min | Testing |
| 210–240 min | Demo prep |

---

## 📌 Key Instructions

- Keep it **simple**
- Focus on **working code**
- Avoid over-engineering
- Use **clear class design**

---

## 🚀 Expected Outcome

A **fully working console application** demonstrating:

- OOP
- Collections
- Exception handling
- File handling
- Basic multithreading

---

## 💡 Tip

Better a simple working system than a complex incomplete one.

---

## 🎉 All the Best!

Build fast. Think simple. Deliver working code.
