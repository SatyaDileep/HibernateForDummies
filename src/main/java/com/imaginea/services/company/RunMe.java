package com.imaginea.services.company;

import com.imaginea.services.company.controller.EmployeeController;
import com.imaginea.services.company.controller.EmployeeControllerImpl;
import com.imaginea.services.company.model.Employee;
import com.imaginea.services.company.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.SessionFactory;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by satyad on 04/05/17.
 * Start point of the application..
 */
public class RunMe {

    final static Logger logger = Logger.getLogger(RunMe.class);
    // path to the hibernate configuration file.. the default file name hibernate looks for is hibernate.cfg.xml
    private static File configFile = new File("src/companydb.cfg.xml");

    public static void main(String[] args) {

        String log4jConfPath = "src/log4j.properties";
        // configuring the log4j properties for logger statements.
        PropertyConfigurator.configure(log4jConfPath);
        logger.info(" Successfully configured log4j .. ");
        EmployeeController employeeController = new EmployeeControllerImpl();

        // Step 1 Configure hibernate through xml or properties.. this is taken care from our singleton class.
        // Step 2 Build sessionFactory
        SessionFactory sessionFactoryInstance = HibernateUtil.getSessionFactory(configFile);
        fetchAllEmployeeDetails(employeeController, sessionFactoryInstance);

        // create employee
        System.out.println("Please enter employee details to insert..");
        Employee employee = employeeController.createEmployee(sessionFactoryInstance, createEmployee());
        logger.info(employee);

        //
        fetchAllEmployeeDetails(employeeController, sessionFactoryInstance);
        System.exit(0);
    }

    private static Employee createEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee createdEmployee = new Employee();
        System.out.println("Enter first name");
        createdEmployee.setFirstName(scanner.next());
        System.out.println("Enter last name");
        createdEmployee.setLastName(scanner.next());
        createdEmployee.setDateOfBirth(new Date(System.currentTimeMillis()));
        System.out.println("Enter mobile");
        createdEmployee.setMobileNumber(scanner.next());
        return createdEmployee;
    }

    private static void fetchAllEmployeeDetails(EmployeeController employeeController, SessionFactory sessionFactoryInstance) {
        // fetch employees
        List<Employee> listOfEmployees = employeeController.fetchEmployees(sessionFactoryInstance);
        logger.info(listOfEmployees);
    }
}
