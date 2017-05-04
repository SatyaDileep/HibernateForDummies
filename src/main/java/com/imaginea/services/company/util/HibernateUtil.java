package com.imaginea.services.company.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 * Created by satyad on 26/04/17.
 * Util class to configure hibernate configuration and to obtain sessionFactory instance.
 * Creating this class as singleton class just to practice the pattern { of-course we are not forming the class object as such..! }
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistryObj;

    private HibernateUtil() {

    }

    public static SessionFactory getSessionFactory(File configFile) {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            if (configFile != null)
                config.configure(configFile);
            else
                config.configure();
            serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistryObj);
            return sessionFactory;
        }
        return sessionFactory;
    }
}
