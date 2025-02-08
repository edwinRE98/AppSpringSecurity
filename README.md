# App Spring Security

This Rest API developed with Spring Boot Security manages a database where there is user information, which are related to certain access roles, these roles allow each user to access a certain message exclusively for their role, these are the administrator role and the standard user role, for the entity ration we use the ManyToMany type, since several users can have several roles and we also handle a one-way type relationship, the execution of this API can be tested through an HTTP query software, the consumption of services from this API It is done with the Spring software integrated into the server, the permissions that each of these has are described below.

Administrator role: read, create, update, delete
Standard User Role: Read

#### URL for query for services
>
> - http://domain/api/security/users/getPublic
> - http://domain/api/security/users/get
> - http://domain/api/security/users/post
> - http://domain/api/security/users/put
> - http://domain/api/security/users/delete


Service routing `<get public>`

    
    @GetMapping("/getPublic")
    public String getPublic(){
        return "This endpoint is public.";
    }
    

Service routing `<get>`

    
    @GetMapping("/get")
    public String standardUser(){
        return "This user has permission to read.";
    }
    

Service routing `<post>`

    
    @PostMapping("/post")
    public String postMessage(){
        return "This user has permission to create.";
    }
    

Service routing `<put>`

    
    @PutMapping("/put")
    public String putMessage(){
        return "This user has permission to update.";
    }
    

Service routing `<delete>`

    
    @DeleteMapping("/delete")
    public String deleteMessage(){
        return "This user has permission to delete.";
    }
    

#### Installation requirements

This API is supported in Java 21, therefore it is recommended to have the same or similar version.

For the database, this API only has a dependency for MySQL, therefore it is recommended that this be the database manager that is managed.

#### Technology stack

- spring security
- Spring web
- Spring Data JPA
- Mysql Driver
- Validation
- Spring boot devtools
- Lombok

#### Versions
- Java version "21.0.2" 2024-01-16 LTS
- Spring Boot 3.4.2
- Maven technology
