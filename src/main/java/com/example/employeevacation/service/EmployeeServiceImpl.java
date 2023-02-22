package com.example.employeevacation.service;

import com.example.employeevacation.dao.Employee;
import com.example.employeevacation.dao.HourlyEmployee;
import com.example.employeevacation.dao.Manager;
import com.example.employeevacation.dao.SalariedEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private static Map<String, Employee> employeeDB = new HashMap<>();

    static {
        for(int i=1; i<=10; i++){
            employeeDB.put("H"+i, new HourlyEmployee("H"+i,"HourlyEmployee"+i));
            employeeDB.put("S"+i, new SalariedEmployee("S"+i,"SalariedEmployee"+i));
            employeeDB.put("M"+i, new Manager("M"+i,"Manager"+i));
        }
    }

//    Updating accumulated vacation based on employee type
//    updating the no of days worked by employee
    @Override
    public Employee work(String employeeId, int daysEmpWorked) {

        Employee employee =employeeDB.get(employeeId);

        if (!employeeId.isEmpty() && 0<daysEmpWorked && daysEmpWorked>260 ) {
            if (employeeId.contains("H")) {
                employee.setVacationDays(10);
                employee.setEmployeeWorkedDays(daysEmpWorked);
                employeeDB.put(employeeId,employee);

            } else if (employeeId.contains("S")) {
                employee.setVacationDays(15);
                employee.setEmployeeWorkedDays(daysEmpWorked);
                employeeDB.put(employeeId,employee);

            } else if (employeeId.contains("M")) {
                employee.setVacationDays(30);
                employee.setEmployeeWorkedDays(daysEmpWorked);
                employeeDB.put(employeeId,employee);

            } else {
                System.err.println("Employee not found");
            }
        } else {
            System.err.println("Invalid number entered");
        }


        return employee;
    }

//    updating the vacation days availability

    @Override
    public Employee takeVacation(String employeeId, float vacationEmpUsed) {

        Employee employee =employeeDB.get(employeeId);

        if (!employeeId.isEmpty() && 0<vacationEmpUsed ) {
            if (employeeId.contains("H") && vacationEmpUsed<=10) {
                employee.setVacationDays((int) (10-vacationEmpUsed));

            } else if (employeeId.contains("S") && vacationEmpUsed<=15) {
                employee.setVacationDays((int) (15-vacationEmpUsed));

            }else if (employeeId.contains("M") && vacationEmpUsed<=30) {
                employee.setVacationDays((int) (30-vacationEmpUsed));
            } else {
                System.err.println("Invalid values entered");
            }

        }
        return employee;
    }


//    retrieves all the employee information
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = null;
        try {
            employees = new ArrayList<>(employeeDB.values());

        } catch (Exception e) {
            System.err.println("Error Occurred " + e);
        }
        return employees;
    }
}
