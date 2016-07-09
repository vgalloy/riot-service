package vgalloy.riotrestservice.controller;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/07/16.
 */
public interface GameController {

    /**
     * Get the information about a game.
     *
     * @param region  the region
     * @param matchId the matchId
     * @return the match detail
     */
    MatchDetailEntity getMatchDetail(Region region, int matchId);
}
