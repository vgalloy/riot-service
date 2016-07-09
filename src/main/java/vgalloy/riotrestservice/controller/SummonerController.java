package vgalloy.riotrestservice.controller;

import java.util.List;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.dao.query.model.Position;
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

    /**
     * Get the position of a summoner with a given champ.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @param championId the champion id
     * @return the position as a list. Each list represent a game
     */
    List<List<Position>> getPosition(Region region, Integer summonerId, Integer championId);
}
