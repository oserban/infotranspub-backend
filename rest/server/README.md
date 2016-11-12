Alfa este prima versiune a serverului REST. Dupa ce se stabilizeaza va deveni beta, si apoi stable. 

Voi trece versiunea de compilator pe Java 7 (openjdk 1.7)


Alfa -> Beta -> .. (acest folder)

The "alfa" application is a REST service, running on Spring. For more information: https://spring.io/guides/gs/rest-service/

To start the app, go to the "alfa" project folder:
 cd rest/server/alfa

Build project files:
 mvn install

The necessary files will be produces in the build folder, which in this example is "target". After that, the application can be run with:
 java -jar target/alfa-1.0.jar

An API test call can be made to:
 http://localhost:8080/api/cities