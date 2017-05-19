

#### Database
Install XAMPP (optional)
Create a database name "pattern"  
(If you want to use a different name, you need to go to AppConfig.java and change to
dataSource.setUrl("jdbc:mysql://localhost:3306/YOURDATABASENAME?useUnicode=yes&characterEncoding=UTF-8"); )

Create a table as follow;
```  
CREATE TABLE `pattern`.`pattern` ( `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT , `NAME` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , `GROUP` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , `IMPLEMENTATION` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_bin;
```
