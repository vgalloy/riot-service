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
     * Update the win rate table every 5 min.
     */
    @Scheduled(fixedDelay = 5 * 60 * 1000) // 5 min
    public void updateWinRate() {
        queryDao.updateWinRate();
    }
}
