package info.bill_tracker.configurations;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${connection.mongo.prefix}")
    private String mongoPrefix;

    @Value("${connection.mongo.username}")
    private String username;

    @Value("${connection.mongo.password}")
    private String password;

    @Value("${connection.mongo.host}")
    private String host;

    @Value("${connection.mongo.database}")
    private String database;

    @Value("${connection.mongo.options}")
    private String options;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(getConnectionString());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }

    private String getConnectionString() {
        StringBuilder connectionString = new StringBuilder();
        return connectionString.append(mongoPrefix)
                .append(username)
                .append(":")
                .append(password)
                .append("@")
                .append(host)
                .append("/")
                .append(database)
                .append("?")
                .append(options)
                .toString();

    }

}
