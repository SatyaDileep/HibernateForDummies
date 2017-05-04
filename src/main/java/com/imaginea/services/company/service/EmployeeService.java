package com.imaginea.services.company.service;

import com.imaginea.services.company.model.Employee;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by satyad on 04/05/17.
 */
public interface EmployeeService {
    List<Employee> fetchEmployees(SessionFactory sessionFactory);

    Employee createEmployee(SessionFactory sessionFactory);
}
