package com.imaginea.services.company.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 * Created by satyad on 26/04/17.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistryObj;

    public HibernateUtil() {

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
