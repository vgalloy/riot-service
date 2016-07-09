package vgalloy.riotrestservice.controller.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.daemon.api.LoaderService;
import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;
import vgalloy.riotrestservice.controller.GameController;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/07/16.
 */
@RestController
public class GameControllerImpl implements GameController{

    private static final Logger LOGGER = LoggerFactory.getLogger(GameControllerImpl.class);

    @Autowired
    private MatchDetailDao matchDetailDao;
    @Autowired
    private LoaderService loaderService;

    @Override
    public MatchDetailEntity getMatchDetail(Region region, int matchId) {
        Optional<MatchDetailEntity> matchDetailEntity = matchDetailDao.get(region, matchId);
        if (matchDetailEntity.isPresent()) {
            return matchDetailEntity.get();
        }
        LOGGER.warn("Use RMI ");
        return loaderService.loadMatchDetail(region, matchId);
    }
}
