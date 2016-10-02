package com.goeuro.service;

import com.goeuro.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by declan on 02/10/16.
 */
@Service
public class LocationClient {

    public static final String BASE_GET_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
    private static final Logger log = LoggerFactory.getLogger(LocationClient.class);

    @Autowired
    public RestTemplate restTemplate;

    public List<Location> findAllLocationsRelatedTo(String city) {

        List<Location> locations = restTemplate.exchange(BASE_GET_URL + city,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Location>>() {
                }).getBody();
        log.debug("Locations Returned from Service" + locations);
        return locations;
    }
}
