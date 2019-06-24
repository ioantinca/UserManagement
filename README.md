# User Management

This is a simple API for managing a customer account.
There are two endpoints: 

    1.  "/openAccount/{customerId}?initialValue={initialValue}" 
    
   which accepts the customer information (customerID, and initialCredit). 


    2. "/getCustomerDetails?customerId={customerId}"
     
   which will output the customer information 

## Running the application

For running the application you need maven and you have to executes this command: 

    "mvn spring-boot:run"
 
 which will deploy the REST application on a Apache Tomcat server on 
    
    localhost:8080
 
 There are three built-in customer for testing purpose:
 
    id 1: John Doe
    id 2: Lionel Messi
    id 3: James Hetfield
    
 Usage example:
    
       http://localhost:8080/openAccount/2?initialValue=600
       http://localhost:8080/getCustomerDetails?customerId=2
 
### Unit test

For simply run the unit tests, please run:
 
    "mvn test"
 
### Building JAR    
    
 You can build a JAR file using:

    "mvn clean package"
