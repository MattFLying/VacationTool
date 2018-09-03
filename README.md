# VacationTool
#### Master degree project presenting functionality of one of the most popular technology Spring for Java.
#### Diploma thesis: Analysis of internet technologies used for the implementation of systems for small and medium-sized enterprises.

## Project
The project is system for management of vacation applications in company. There are three types of users: Employee, Manager and administrator. Each of them is able to browse own data and vacation applications which this user created. Manager and administrator  also can manage of applications addressed to them with the proviso that administrator can browse all applications in system where manager can browse only these applications which were addressed to him.
## Technologies
Java 8 + Spring Boot + Spring Security + Hibernate + Thymeleaf + Bootstrap + jQuery. IDE Eclipse Mars.2

## Author
 - Mateusz Mucha aka [Vallendir](https://github.com/Vallendir) 
 - Email: mateusz.marek.mucha@gmail.com
 

### Project during refactoring...[27.08.2018]
##### Final version for master degree is on Branch 0.4.0. Refactoring Branch 0.5.0+.
##### After refactoring
Three maven modules:
- Core is a module with common functionality and types to use whenever in other modules
- Web is main module with services, controllers and front end pages
- DB is a database module which is currently done. There are two technologies: Spring Data and Hibernate which allow to operate on database via java code. Practically these two technologies in one project does not make sense but were used to show possibilities. The main technology used in Web module to oeprate on database is Spring Data. Hibernate implementation is not used.
