package vgalloy.riotrestservice.controller.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.daemon.api.LoaderService;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;
import vgalloy.riotrestservice.controller.SummonerController;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 20/06/16.
 */
@RestController
public class SummonerControllerImpl implements SummonerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummonerControllerImpl.class);

    @Autowired
    private RankedStatsDao rankedStatsDao;
    @Autowired
    private LoaderService loaderService;

    @Override
    @RequestMapping(value = "{region}/summoner/{summonerId}", method = RequestMethod.GET)
    public RankedStatsEntity getRankedStat(@PathVariable Region region, @PathVariable Integer summonerId) {
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.get(region, summonerId);
        if (rankedStatsEntity.isPresent()) {
            return rankedStatsEntity.get();
        }
        LOGGER.warn("Not found");
        RankedStatsDto rankedStatsDto = loaderService.loadRankedStat(region, summonerId);
        System.out.println(rankedStatsDto);
        return null;
    }
}
