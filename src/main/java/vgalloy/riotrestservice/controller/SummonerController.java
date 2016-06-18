package vgalloy.riotrestservice.controller;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent on 18/06/2016.
 */
public interface SummonerController {

    /**
     * Get the ranked stats.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the ranked stats
     */
    RankedStatsEntity getRankedStat(Region region, Integer summonerId);
}
