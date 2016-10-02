package com.goeuro.service;

import com.goeuro.domain.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by declan on 02/10/16.
 */
@Component
public class CityInfoParser {

    private static final Logger log = LoggerFactory.getLogger(CityInfoParser.class);

    @Autowired
    public CsvGenerator csvGenerator;
    @Autowired
    private LocationClient locationClient;


    public void run(String... mainArgs) throws Exception {
        String city = mainArgs[0];
        List<Location> locations = locationClient.findAllLocationsRelatedTo(city);
        if(!locations.isEmpty())
            csvGenerator.createCsv(city, locations);
        else
            log.warn("There were no Locations found for this City: " + city);

    }

}
