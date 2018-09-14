package local.kapinos.chapter15.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;

/** 
 * https://stackoverflow.com/questions/15100761/configuring-mysql-datasource-using-datasourcedefinition-in-jboss-as7
 * https://stackoverflow.com/questions/14084606/glassfish-can-not-find-jndi-datasource-while-deploying
 */
@Singleton 
@DataSourceDefinition(
		className = "org.apache.derby.jdbc.EmbeddedDataSource", 
		name = "java:app/jdbc/embeddedChapter15", 
		user = "app", 
		password = "app", 
		databaseName = "chapter15", 
		properties = {"connectionAttributes=;create=true" })
public class EmbeddedDerbyDbPopulator {

}