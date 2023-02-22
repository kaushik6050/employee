package com.example.employeevacation.dao;

public class Employee {
    private String employeeId;
    private String employeeName;

    private String employeeType;


    private int vacationDays;
    private float employeeWorkedDays;

    public Employee(String employeeId, String employeeName, String employeeType) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.vacationDays = 0;
        this.employeeWorkedDays = 260;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public float getEmployeeWorkedDays() {
        return employeeWorkedDays;
    }

    public void setEmployeeWorkedDays(float employeeWorkedDays) {
        this.employeeWorkedDays = employeeWorkedDays;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", vacationDays=" + vacationDays +
                ", employeeWorkedDays=" + employeeWorkedDays +
                '}';
    }
}
