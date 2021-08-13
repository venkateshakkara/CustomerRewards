# rewards-demo

The service populate h2 db with data.sql file

Environment:
JAVA 11

To build the application run below command:
mvn clean install

To run the service use below command:
mvn spring-boot:run

Application will start on 9000 port.

To view h2 DB console: 
http://localhost:9000/h2-console

JDBC URL will be avaiable in the logs too.

To Get All customers:
curl -X GET -H 'Accept: application/json' -H 'Content-Type: application/json' -i http://localhost:9000/customers

To get Customere having id = 101
curl -X GET -H 'Accept: application/json' -H 'Content-Type: application/json' -i http://localhost:9000/customers/101



