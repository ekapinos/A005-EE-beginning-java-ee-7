package local.kapinos.chapter09.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;

@Singleton // https://stackoverflow.com/questions/15100761/configuring-mysql-datasource-using-datasourcedefinition-in-jboss-as7
//@Startup // changes nothing
//@ApplicationScoped // does not work
@DataSourceDefinition(
		className = "org.apache.derby.jdbc.EmbeddedDataSource", 
		name = "java:global/jdbc/embeddedDerbyDb", 
		user = "app", 
		password = "app", 
		databaseName = "embeddedDerbyDb", 
		properties = {"connectionAttributes=;create=true" })
public class EmbeddedDerbyDbPopulator {

}