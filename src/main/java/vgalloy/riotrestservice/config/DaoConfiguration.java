package vgalloy.riotrestservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import vgalloy.riot.daemon.api.LoaderService;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/06/16.
 */
@Configuration
public class DaoConfiguration {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Bean
    public QueryDao getQueryDao() {
        return MongoDaoProvider.INSTANCE.getQueryDao(databaseUrl);
    }

    @Bean
    public RankedStatsDao getRankedStatsDaoImpl() {
        return MongoDaoProvider.INSTANCE.getRankedStatsDao(databaseUrl);
    }

    /**
     * Get LoadingService.
     *
     * @return the loading service
     */
    @Bean
    public LoaderService getLoadingService() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:5000/LoaderService");
        rmiProxyFactoryBean.setServiceInterface(LoaderService.class);
        rmiProxyFactoryBean.afterPropertiesSet();

        return (LoaderService) rmiProxyFactoryBean.getObject();
    }
}
