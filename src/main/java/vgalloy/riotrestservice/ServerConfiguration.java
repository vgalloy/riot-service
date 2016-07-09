package vgalloy.riotrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 13/06/16.
 */
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class, MongoAutoConfiguration.class})
public class ServerConfiguration {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerConfiguration.class, args);
    }
}
