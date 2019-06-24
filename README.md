# User Management

This is a simple API for managing a customer account.
There are two endpoints: 

    "/openAccount/{customerId}" 
    
   which accepts the customer information (customerID, and initialCredit). 


    "/getCustomerDetails?customerId={customerId}"
     
   which will output the customer information 

## Running the application

For running the application you will need to run: 

    "mvn spring-boot:run"
 
 which will deploy the REST application on a Tomcat Apache Server on localhost:8080
 
 
 


For simply run the unit tests, please run:
 
    "mvn test"
    
 You can build a Jar file using:

    "mvn clean package"
