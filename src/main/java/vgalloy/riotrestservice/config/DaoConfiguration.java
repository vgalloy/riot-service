package vgalloy.riotrestservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * Created by Vincent Galloy on 15/06/16.
 */
@Configuration
public class DaoConfiguration {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Bean
    public QueryDao getQueryDao() {
        return MongoDaoProvider.INSTANCE.getQueryDao(databaseUrl);
    }
}
