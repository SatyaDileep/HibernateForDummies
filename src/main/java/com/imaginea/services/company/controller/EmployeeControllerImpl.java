package com.imaginea.services.company.controller;

import com.imaginea.services.company.model.Employee;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.List;

/**
 * Created by satyad on 26/04/17.
 */
public class EmployeeControllerImpl implements EmployeeController {

    final static Logger logger = Logger.getLogger(EmployeeControllerImpl.class);
    // path to the hibernate configuration file.. the default file name hibernate looks for is hibernate.cfg.xml
    private static File configFile = new File("src/companydb.cfg.xml");

    public static void main(String[] args) {
        String log4jConfPath = "src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        System.out.println("building session factory");
        logger.error(" /// hey there");
        System.exit(0);
    }

    public List<Employee> fetchEmployees() {
        return null;
    }
}
