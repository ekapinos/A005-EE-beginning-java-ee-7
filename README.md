# Java EE - Beginning Java EE 7 - book study

## Environment:
* GlassFish Server 4.1.1
* JDK 1.8.0_91
* Maven 3.3.9
 
## Setup
1. Startup Application Server and DataBase
  * Dig in `cd glassfish-4.1.1\glassfish\bin\`
  * GlassFish Server: `startserv.bat`
  * Derby Server: `asadmin start-database` (User=APP, Password=APP, DatabaseName=sun-appserv-samples)
2. Build project with Maven. 
3. Deploy `ear` into you GlassFish Server

## Useful links
* [Book sale](http://www.apress.com/9781430246268?gtmf=s)
* [Book's Author blog](https://antoniogoncalves.org/2013/05/29/beginning-java-ee-7-book-arriving-soon/)
* [Book Source Code Samples](https://github.com/agoncal/agoncal-book-javaee7)
* [Java EE 7 spec](https://docs.oracle.com/javaee/7/tutorial/index.html)