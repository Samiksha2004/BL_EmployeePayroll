package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();  // Storing Employees in Memory

    // Add Employee to List
    public Employee addEmployee(Employee employee) {
        employee.setId((long) (employeeList.size() + 1));  // Auto-generate ID
        employeeList.add(employee);
        return employee;
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                updatedEmployee.setId(id);
                employeeList.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null; // Or throw an exception
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
