package com.message.messagekafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig  extends AbstractCassandraConfiguration{

	
	@Value("${cassandra.keyspace}")
	private String keyspace;
	
	
	
	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}

	

	@Override

	  public SchemaAction getSchemaAction() {

	    return SchemaAction.CREATE_IF_NOT_EXISTS;

	  }




	
	
}
