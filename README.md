# Project Tracking System repo
## Spring Boot project
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template?ref=badge_shield)

The only thing better than a Maven archetype is a repo you can fork with everything already setup. Skip the documentation and just fork-and-code. 

Delete the sample code, replace with your own and you’re good to go.

## Built With

* 	[StarUML](https://staruml.io/) - A sophisticated software modeler for agile and concise modeling (UML)
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[Flyway](https://flywaydb.org/) - Version control for database
* 	[JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[Docker](https://docker.com/) - Developing apps today requires so much more than writing code. Multiple languages, frameworks, architectures, and discontinuous interfaces between tools for each lifecycle stage creates enormous complexity. Docker simplifies and accelerates your workflow, while giving developers the freedom to innovate with their choice of tools, application stacks, and deployment environments for each project.
* 	[Twilio API](https://www.twilio.com//) - Contactless Delivery - Remote Contact Centers - Distance Learning - Video Support - Mass Notifications
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## Done

- [x] Logger (Console, File, Mail)
- [x] RESTful Web Service (CRUD)
- [x] Bootstrap - CSS
- [x] Web - HTML, JavaScript (jQuery)
- [x] Content Negotiation
- [x] Material Design for Bootstrap
- [x] Docker
- [x] Spring Boot Admin
- [x] Spring Security
- [x] Spring Data Jpa
- [x] Spring AOP
- [x] MySQL
- [x] H2
- [x] Swagger
- [x] Twilio API
- [x] JFreeChart
- [x] Heroku deployment
- [ ] More .... ;) 


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.selimhorri.app.pack` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Start your local MySQL database
- Import pfa_db.sql 
```shell 
source ./pfa_db.sql 
```
- Build the project
```shell 
./mvnw clean install 
```
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Spring Boot App
- Or, Run on different env : 
- On Dev :

```shell
java -jar target/project-tracking-sys.jar
java -Dspring.profiles.active=dev -jar target/project-tracking-sys.jar
```

- On Test :

```shell
java -Dspring.profiles.active=test -jar target/project-tracking-sys.jar
```

- On Test :

```shell
java -Dspring.profiles.active=prod -jar target/project-tracking-sys.jar
```

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


Spring Boot Starter Security default username is `user` and a generated security password is printed in the console like `Using generated security password: ?`

Automated dependency updates done via [Dependabot](https://dependabot.com/)

### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://localhost:8080`  						| GET |
|`http://localhost:8080/actuator/`             | GET |
|`http://localhost:8080/actuator/health`    	| GET |
|`http://localhost:8080/actuator/info`      	| GET |
|`http://localhost:8080/actuator/prometheus`| GET |
|`http://localhost:8080/actuator/httptrace` | GET |

### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/app`                           
|`http://localhost:8080/app/employees`                           | GET | Custom Response Headers|
|`http://localhost:8080/app/managers`                 	     | GET | |
|`http://localhost:8080/app/admins`            			     | GET | |

### Employees URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/app/employees/employee-index`                           | GET | |
|`http://localhost:8080/app/employees/employee-show-my-commits`                       | GET | |
|`http://localhost:8080/app/employees/employee-add-commit`                       | GET | |
|`http://localhost:8080/app/employees/employee-show-all-commits`                       | GET | |
|`http://localhost:8080/app/credentials/credential-edit`                       | GET | |
|`http://localhost:8080/app/employees/employee-team`                       | GET | |

### Managers URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/app/managers/manager-index`                           | GET | |
|`http://localhost:8080/app/managers/manager-add-project`                       | GET | |
|`http://localhost:8080/app/managers/manager-show-commits`                       | GET | |
|`http://localhost:8080/app/managers/manager-describe-commit`                       | GET | |
|`http://localhost:8080/app/managers/manager-assign`                       | GET | |
|`http://localhost:8080/app/managers/manager-edit-project`                       | GET | |
|`http://localhost:8080/app/managers/manager-delete-project`                       | GET | |
|`http://localhost:8080/app/managers/manager-info`                       | GET | |
|`http://localhost:8080/app/managers/manager-team`                       | GET | |
|`http://localhost:8080/app/managers/manager-assigned-projects`                       | GET | |
|`http://localhost:8080/app/credentials/credential-edit`                       | GET | |

### Admins URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/app/admins/admin-index`                           | GET | |
|`http://localhost:8080/app/admins/employees/admin-employees-list`                       | GET | |
|`http://localhost:8080/app/admins/employees/admin-employees-add`                       | GET | |
|`http://localhost:8080/app/admins/employees/admin-employees-edit`                       | GET | |
|`http://localhost:8080/app/admins/employees/admin-employee-credentials`                       | GET | |
|`http://localhost:8080/app/admins/employees/admin-employees-isactive`                       | GET | |
|`http://localhost:8080/app/admins/employees/admin-employees-delete`                       | GET | |
|`http://localhost:8080/app/admins/departments/admin-departments-list`                       | GET | |
|`http://localhost:8080/app/admins/departments/admin-departments-edit`                       | GET | |
|`http://localhost:8080/app/admins/departments/admin-departments-delete`                       | GET | |
|`http://localhost:8080/app/admins/locations/admin-locations-list`                       | GET | |
|`http://localhost:8080/app/admins/locations/admin-locations-edit`                       | GET | |
|`http://localhost:8080/app/admins/locations/admin-locations-delete`                       | GET | |

## Documentation

* [Postman Collection](https://documenter.getpostman.com/view/2449187/RWTiwzb2) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages
* [Postman Collection](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/blob/master/Spring%20Boot%20Template.postman_collection.json) - offline
* [Swagger](http://localhost:8080/swagger-ui.html) - Documentation & Testing

## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
.
├── employees-management
├── src
│   └── main
│       └── java
│           ├── com.pfa.pack.pack
│           ├── com.pfa.pack.pack.configs
│           ├── com.pfa.pack.pack.configs.swagger
│           ├── com.pfa.pack.pack.configs.cors
│           ├── com.pfa.pack.pack.configs.twilio
│           ├── com.pfa.pack.pack.configs.modelmapper
│           ├── com.pfa.pack.pack.controllers
│           ├── com.pfa.pack.pack.controllers.api
│           ├── com.pfa.pack.pack.controllers.employee
│           ├── com.pfa.pack.pack.controllers.manager
│           ├── com.pfa.pack.pack.controllers.admin
│           ├── com.pfa.pack.pack.converters
│           ├── com.pfa.pack.pack.enums
│           ├── com.pfa.pack.pack.security
│           ├── com.pfa.pack.pack.security.
│           ├── com.pfa.pack.pack.exceptions
│           ├── com.pfa.pack.pack.exceptions.customs
│           ├── com.pfa.pack.pack.exceptions.payloads
│           ├── com.pfa.pack.pack.models
│           ├── com.pfa.pack.pack.models.entities
│           ├── com.pfa.pack.pack.models.ids
│           ├── com.pfa.pack.pack.models.dto
│           ├── com.pfa.pack.pack.models.collectionwrappers
│           ├── com.pfa.pack.pack.utils
│           ├── com.pfa.pack.pack.utils.email
│           ├── com.pfa.pack.pack.utils.sms
│           ├── com.pfa.pack.pack.utils.report
│           ├── com.pfa.pack.pack.repositories
│           └── com.pfa.pack.pack.services
│           └── com.pfa.pack.pack.services.impls
├── src
│   └── main
│       └── resources
│           └── static
│           │   ├── css
│           │   ├── js 
│           └── templates
│           │   ├── admins
│           │   ├── employees
│           │   ├── managers
│           │   ├── credentials
│           │   ├── home
│           ├── application.properties
│           ├── application-dev.properties
│           ├── application-test.properties
│           ├── application-prod.properties
│           ├
│           └── 
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── bin
├── logs
│   └── application.log
├── src
├── target
│   └──project-tracking-system.jar
├── mvnw
├── mvnw.cmd
├── pfa_db.sql
├── pfa_ERD.png
├── pom.xml
└── README.md
```

## packages

- `models` — to hold our entities;
- `repositories` — to communicate with the database;
- `services` — to hold our business logic;
- `security` — security configuration;
- `controllers` — to listen to the client;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/static` - contains static resources such as css, js and images.
- `resources/templates` - contains server-side templates which are rendered by Spring.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies
 
## Reporting Issues

This Project uses GitHub's integrated issue tracking system to record bugs and feature requests. If you want to raise an issue, please follow the recommendations below:

* Before you log a bug, please https://github.com/SelimHorri/Project-Tracking-System/search?type=Issues[search-the-issue-tracker]
  to see if someone has already reported the problem.
* If the issue doesn't already exist, https://github.com/SelimHorri/Project-Tracking-System/issues/new[create-a-new-issue]. 
* Please provide as much information as possible with the issue report.
* If you need to paste code, or include a stack trace use Markdown +++```+++ escapes before and after your text. 
  
## Resources

* [My API Lifecycle Checklist and Scorecard](https://dzone.com/articles/my-api-lifecycle-checklist-and-scorecard)
* [HTTP Status Codes](https://www.restapitutorial.com/httpstatuscodes.html)
* [Bootstrap w3schools](https://www.w3schools.com/bootstrap/)
* [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)


-- ## License


