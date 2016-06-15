package vgalloy.riotrestservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riotrestservice.controller.ChampionController;

import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 13/06/16.
 */
@RestController
public class ChampionControllerImpl implements ChampionController {

    @Autowired
    private QueryDao queryDao;

    @Override
    @RequestMapping(value = "/champion/{championId}/winRate", method = RequestMethod.GET)
    public Map<Integer, Double> getWinRate(@PathVariable Integer championId) {
        return queryDao.getWinRate(championId);
    }
}
