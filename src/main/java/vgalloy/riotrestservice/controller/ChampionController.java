package vgalloy.riotrestservice.controller;

import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 14/06/16.
 */
public interface ChampionController {

    /**
     * Get the win rate of a champion as a map. The key is the number of game played.
     *
     * @param championId the champion id
     * @return the win rates as a map
     */
    Map<Integer, Double> getWinRate(Integer championId);
}
