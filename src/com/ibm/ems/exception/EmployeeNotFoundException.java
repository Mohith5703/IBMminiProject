
package com.ibm.ems.exception;

//Custom Exception - thrown when employee is not found
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {

 public EmployeeNotFoundException(String message) {
     super(message);
 }
}