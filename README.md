# Java EE - Beginning Java EE 7 - book study

## Environment:
* JDK build 1.8.0_91-b14
* GlassFish Server Open Source Edition 4.1.2 (build 1).
* Maven 3.3.9
 
## Setup
1. Start Application Server and bundled DataBase
  * Dig into `glassfish-4.1.1\glassfish\bin\`
  * Start GlassFish Application Server. `asadmin start-domain` (check http://localhost:4848/)
  * Start Derby DB Server. `asadmin start-database` (default User=APP, Password=APP, DatabaseName=sun-appserv-samples)
2. Build project with Maven `mvn install`. 
3. Deploy artifacts.

## Useful links
* [Book's sales](http://www.apress.com/9781430246268?gtmf=s)
* [Book Author's blog](https://antoniogoncalves.org/2013/05/29/beginning-java-ee-7-book-arriving-soon/)
* [Book Source Code Samples](https://github.com/agoncal/agoncal-book-javaee7)
* [Java EE 7 spec](https://docs.oracle.com/javaee/7/tutorial/index.html)