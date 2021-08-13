# rewards-demo-main

The service populate h2 db with data.sql file

Environment:
JAVA 11

To build the application run below command:
mvn clean install

To run the service use below command:
mvn spring-boot:run

Application will start on 7000 port.

To view h2 DB console: 
http://localhost:7000/h2-console

JDBC URL will be avaiable in the logs too.

To Get All customers:
curl -X GET -H 'Accept: application/json' -H 'Content-Type: application/json' -i http://localhost:7000/reward/getAllCustomers

To get Customere having id = 500
curl -X GET -H 'Accept: application/json' -H 'Content-Type: application/json' -i http://localhost:7000/reward/getCustomerById/500



