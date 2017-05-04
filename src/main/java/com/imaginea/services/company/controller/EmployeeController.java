package com.imaginea.services.company.controller;

import com.imaginea.services.company.model.Employee;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by satyad on 26/04/17.
 */
public interface EmployeeController {

    List<Employee> fetchEmployees(SessionFactory sessionFactory);

    Employee createEmployee(SessionFactory sessionFactory, Employee employee);

}
