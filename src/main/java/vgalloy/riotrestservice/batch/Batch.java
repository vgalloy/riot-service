package vgalloy.riotrestservice.batch;

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

    @Autowired
    private QueryDao queryDao;

    /**
     * Update the win rate table every 10 min.
     */
    @Scheduled(fixedDelay = 10 * 60 * 1000) // 10 min
    public void updateWinRate() {
        queryDao.updateWinRate();
    }
}
