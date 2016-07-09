package vgalloy.riotrestservice.controller.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vgalloy.riotrestservice.controller.HomeController;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/06/16.
 */
@RestController
@PropertySource(value = "classpath:META-INF/maven/vgalloy/riot-restservice/pom.properties", ignoreResourceNotFound = true)
public class HomeControllerImpl implements HomeController {

    @Value("${version:none}")
    private String version;

    @Override
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome() {
        return "{\"status\": \"running\", \"version\":\"" + version + "\"}";
    }
}
