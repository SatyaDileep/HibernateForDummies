package com.imaginea.services.company.controller;

import com.imaginea.services.company.model.Employee;

import java.util.List;

/**
 * Created by satyad on 26/04/17.
 */
public interface EmployeeController {

    public List<Employee> fetchEmployees();

}
