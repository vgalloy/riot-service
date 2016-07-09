package vgalloy.riotrestservice.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import vgalloy.riot.database.mongo.dao.query.QueryDao;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/06/16.
 */
@Component
public class Batch {

    private static final Logger LOGGER = LoggerFactory.getLogger(Batch.class);

    @Autowired
    private QueryDao queryDao;

    /**
     * Update the win rate table every 10 min.
     */
    @Scheduled(fixedDelay = 10 * 60 * 1000) // 10 min
    public void updateWinRate() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ START ] : updateWinRate");
        queryDao.updateWinRate();
        LOGGER.info("[ END ] : updateWinRate {} ms", System.currentTimeMillis() - startTime);
    }

    /**
     * Update the position table.
     */
    @Scheduled(fixedDelay = 10 * 60 * 1000) // 10 min
    public void updatePosition() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ START ] : updatePosition");
        queryDao.updatePosition();
        LOGGER.info("[ END ] : updatePosition {} ms", System.currentTimeMillis() - startTime);
    }
}
