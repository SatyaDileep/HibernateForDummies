package com.imaginea.services.company.controller;

import com.imaginea.services.company.model.Employee;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by satyad on 26/04/17.
 */
public class EmployeeControllerImpl implements EmployeeController {

    final static Logger logger = Logger.getLogger(EmployeeControllerImpl.class);

    /**
     * Method to get all employees from the database
     *
     * @param sessionFactoryInstance
     * @return
     */
    public List<Employee> fetchEmployees(SessionFactory sessionFactoryInstance) {
        Session currentSession = sessionFactoryInstance.openSession();
        try {
            logger.info("Querying all employees details..!");
            return currentSession.createQuery("from Employee").list();
        } finally {
            currentSession.close();
        }
    }

    /**
     * Creates new Employee instance
     *
     * @param sessionFactory
     * @param employee
     * @return
     */
    public Employee createEmployee(SessionFactory sessionFactory, Employee employee) {
        logger.info("creating employee..!");
        Employee createdEmp;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Serializable obj = session.save(employee);
            createdEmp = (Employee) session.get(Employee.class, obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Exception occured due to " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
        return createdEmp;
    }

}
