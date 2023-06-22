# Spring Boot 3 Project

## Topics explored

- Spring Core: IoC Container -> Dependency Injection & Configuration

  How can we inject configuration into the application?
  
  - On every class variable, add a @Value("${property.name: defaultValue}"
  With the above, the "property.name" will be lookuped up in the configuration. If the property is not set, then it will default to "defaultValue"
  This has the downside of no type checking.

  - Another option is to create a class and annotate it with @ConfigurationProperties, for example:

        @Configuration
        @ConfigurationProperties(prefix = "mail")
        public record ConfigProperties(String hostName, int port, String from) {}
  	  
    To make this work we will also have to annotate with @EnableConfigurationProperties(ConfigProperties.class) the class where our main method will execute

- Spring MVC -> RestController - Mapping - ResponseStatus - Data Validation

- Spring JDBC -> I use the JdbcTemplate class to write my own queries and interact with the Database.

- Spring Data
  
  I create an interface (ContentRepository) that extends ListCrudRepository<Content,Integer>. 
  In <Content,Integer>, Content is a class that is mapped to a DB Table (This classes are called Entities). 
  Integer indicates that the PK of the table is an int. 
  
  Spring creates an implementation of that interface on runtime and provides methods to interact with Content.
  I use ListCrudRespository because it returns Lists while CrudRepository returns iterables.

  I also have another entity X, but the name of this entity is different from the table name,
  so we annotate this class with @Table(name = "actual_table_name")