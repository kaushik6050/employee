package com.example.employeevacation.service;

import com.example.employeevacation.dao.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee work(String emplyeeId, int daysEmpWorked);
    public Employee takeVacation(String emplyeeId, float vacationEmpUsed);

    public List<Employee> getAllEmployees();
}
