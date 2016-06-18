package vgalloy.riotrestservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;
import vgalloy.riotrestservice.controller.SummonerController;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response.Status;
import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 20/06/16.
 */
@RestController
public class SummonerControllerImpl implements SummonerController {

    @Autowired
    private RankedStatsDaoImpl rankedStatsDao;

    @Override
    @RequestMapping(value = "{region}/summoner/{summonerId}", method = RequestMethod.GET)
    public RankedStatsEntity getRankedStat(@PathVariable Region region, @PathVariable Integer summonerId) {
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.get(region, summonerId);
        if (rankedStatsEntity.isPresent()) {
            return rankedStatsEntity.get();
        }
        throw new ClientErrorException(Status.NOT_FOUND);
    }
}
