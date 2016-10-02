package com.goeuro.service;

import com.goeuro.domain.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by declan on 02/10/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityInfoParserTest {

    private static final String BERLIN = "Berlin";
    private static final String DUBLIN = "Dublin";
    @Mock
    public CsvGenerator csvGenerator;
    @Mock
    private LocationClient locationClient;
    @InjectMocks
    private CityInfoParser cityInfoParser = new CityInfoParser();

    @Test
    public void testRunHappyPath() throws Exception {
        List<Location> locations = createLocations(BERLIN, DUBLIN);
        when(locationClient.findAllLocationsRelatedTo(BERLIN)).thenReturn(locations);
        doNothing().when(csvGenerator).createCsv(BERLIN, locations);
        cityInfoParser.run(BERLIN);
        verify(locationClient).findAllLocationsRelatedTo(BERLIN);
        verify(csvGenerator).createCsv(BERLIN, locations);
    }

    @Test
    public void testRunNoLocations() throws Exception {
        when(locationClient.findAllLocationsRelatedTo(BERLIN)).thenReturn(new ArrayList());
        cityInfoParser.run(BERLIN);
        verify(locationClient).findAllLocationsRelatedTo(BERLIN);
        verifyNoMoreInteractions(csvGenerator);
    }

    private List<Location> createLocations(String... cities) {
        List<Location> locations = new ArrayList();
        for(String city : cities)
            locations.add(Location.newLocation().name(city).id(UUID.randomUUID().toString()).build());
        return locations;
    }
}