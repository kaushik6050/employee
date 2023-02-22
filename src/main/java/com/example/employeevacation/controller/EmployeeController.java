package com.example.employeevacation.controller;

import com.example.employeevacation.dao.Employee;
import com.example.employeevacation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(path="/employees", produces = "application/json")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PutMapping(path="/vacation/{employeeId}/{vacationDays}", produces = "application/json")
    public Employee updateVacation(@PathVariable("employeeId") String employeeId,
                                    @PathVariable("vacationDays") int vacationDays) {
        return service.takeVacation(employeeId,vacationDays);
    }


    @PutMapping(path="/work/{employeeId}/{workedDays}", produces = "application/json")
    public Employee updateWorkDays(@PathVariable("employeeId") String employeeId,
                                    @PathVariable("workedDays") int workedDays) {
        return service.work(employeeId,workedDays);
    }

}
