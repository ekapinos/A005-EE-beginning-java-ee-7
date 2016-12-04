# Java EE - Beginning Java EE 7 - book study

## Environment:
* JDK 1.8.0_91
* GlassFish Server 4.1.1
* Maven 3.3.9
 
## Setup
1. Startup Application Server and bundled DataBase
  * Dig in. `glassfish-4.1.1\glassfish\bin\`
  * Start GlassFish Application Server. `asadmin start-domain` (check it http://localhost:4848/)
  * Start Derby DB Server. `asadmin start-database` (default User=APP, Password=APP, DatabaseName=sun-appserv-samples)
2. Build project with Maven `mvn install`. 
3. Deploy artifacts.

## Useful links
* [Book sales](http://www.apress.com/9781430246268?gtmf=s)
* [Book's Author blog](https://antoniogoncalves.org/2013/05/29/beginning-java-ee-7-book-arriving-soon/)
* [Book Source Code Samples](https://github.com/agoncal/agoncal-book-javaee7)
* [Java EE 7 spec](https://docs.oracle.com/javaee/7/tutorial/index.html)