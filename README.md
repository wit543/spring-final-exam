# Assignment 3 - Design Patterns with Java Spring
Software Patterns and Architecture Final on implementing a Spring MVC and Spring JDBC
## Getting Started
Clone this project to your local machine.
### Prerequisites

[Spring Tool Suuuuuuuuuuuuite](https://spring.io/tools/sts/all) - Spring variant of Eclipse.  
Note: Of course, you can use your editor of choice i.e, IntelliJ, but you will have to manually setup a lot of stuffs and I won't cover that. Just use this one if you are lazy like me.

[Apache Tomcat 8.0.43](https://tomcat.apache.org/download-80.cgi) - Java Servlet
 
[XAMPP](https://www.apachefriends.org/download.html) - For hosting MySQL database.  
Note: You don't need this, if you can already host a database and create a table in it.

### Installing

#### Database
Install XAMPP (optional)
Create a database name "assignment3"  
(If you want to use a different name, you need to go to AppConfig.java and change to
dataSource.setUrl("jdbc:mysql://localhost:3306/YOURDATABASENAME?useUnicode=yes&characterEncoding=UTF-8"); )

Create a table as follow;
```  
CREATE TABLE `pattern`.`pattern` ( `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT , `NAME` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , `GROUP` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , `IMPLEMENTATION` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_bin;
```

#### Spring
Extract both Spring tool suite and Apache Tomcat to anywhere you wish.  
Launch the suite and choose File>Open Project From File System..., navigate to this project and wait for Maven to update dependencies.  
Try running the project and it should prompt you to use an existing server or define a new server.  
Choose to define a new server and under Select the server type, look for Apache Tomcat 8.0.  
Click Next. Then, one the next page click on Browse and navigate to the extracted Apache Tomcat 8.0.43.  
Detailed Installation of Apache Tomcat refers to this [How to setup tomcat with Eclipse](http://websystique.com/misc/how-to-setup-tomcat-with-eclipse/)
After finished home page of this project should pop up once the server is ready.  
Once ready, the home page of this project should pop up

### How to run (Credit: Nattapat )
    1. Run Tomcat server.

    2. Run XAMPP, start Apache and MySQL modules.

    3. Open URL http://localhost:8080/assignment3/


### References
* [Spring 4 MVC+Apache Tiles 3 Example](http://websystique.com/springmvc/spring-4-mvc-apache-tiles-3-annotation-based-example/)
* [How to setup tomcat with Eclipse](http://websystique.com/misc/how-to-setup-tomcat-with-eclipse/)