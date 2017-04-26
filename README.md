# HibernateForDummies
Simple Hibernate project

Hibernate :

- ORM framework which means .. Object (Java application) -> Relational (Database) Mapping.
- Traditional JDBC applications doesnt support object mapping and hence we store as text but hibernate eliminates it by introducing orm
- In JDBC user needs to handle exceptions as they are all checked but hibernate has unchecked excpetions
- In JDBC we write sql commands everywhere so if the table structure changes, we need to modify at every place
- Hibernate provides HQL which is databse independent
- If we save derived class obj in hibernate then base class object also gets saved.
- Primary keys can be generated automatically by hibernate
- Hibernate provides caching to improve performance by reducing no.of calls between app and db
- Pagination based querying is quite simple in hibernate

== Steps involved in interacting with db using hibernate ==
1. Load configuration. { either configuration file or props file }
2. Obtain SessionFactory instance { configuration.buildSessionFactory() }
3. Open Session using sessionFactory instance.
 
 Configuration :
 - 2 ways to configure : properties file and XML. XML is preferred.
 - Configuration file consists of connection properties, mapping config, db behavorial properties etc.

Mapping and configuration are the heart for any hibernate application.
- Mapping is generally taken through Annotations / XML. There can be multiple mapping files { no. of POJO's=no. of mapping files}
- Using annotations is more simpler. Mapping config contains the mapping between java object and database columns which tells hibernate which kind of value to be stored in the db.
- Mapping config is then attached in configuration file. Configuration file is generally XML, older versions properties file is also used for this purpose but xml is preferred.
