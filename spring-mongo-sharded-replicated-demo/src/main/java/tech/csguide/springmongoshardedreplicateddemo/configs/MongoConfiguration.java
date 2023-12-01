package tech.csguide.springmongoshardedreplicateddemo.configs;

import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoConfiguration {

    @Value("${app.mongodb.config1.database}")
    private String database;

    @Value("${app.mongodb.config1.uri}")
    private String uri;


    private MongoClient mongoClient;

    @Bean(name = "wBlogMongoTemplate")
    public MongoTemplate wBlogMongoTemplate() {
        MongoTemplate wBlogMongoTemplate = new MongoTemplate(mongoClient(), database);
        wBlogMongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        return wBlogMongoTemplate;
    }

    @Bean(name = "rBlogMongoTemplate")
    public MongoTemplate rBlogMongoTemplate() {
        MongoTemplate rBlogMongoTemplate = new MongoTemplate(mongoClient(), database);
        rBlogMongoTemplate.setReadPreference(ReadPreference.secondaryPreferred());
        return rBlogMongoTemplate;
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    //Enable MongoRepositories for different mongoTemplate
    @EnableMongoRepositories(basePackages = "tech.csguide.springmongoshardedreplicateddemo.repositories.blogread", mongoTemplateRef = "rBlogMongoTemplate")
    public class MarkerRepositoryConfigurationBlogRead {
    }

    //Enable MongoRepositories for different mongoTemplate
    @EnableMongoRepositories(basePackages = "tech.csguide.springmongoshardedreplicateddemo.repositories.blogwrite", mongoTemplateRef = "wBlogMongoTemplate")
    public class MarkerRepositoryConfigurationBlogWrite {
    }


}
