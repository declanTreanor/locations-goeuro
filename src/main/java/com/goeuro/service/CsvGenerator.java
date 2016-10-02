package com.goeuro.service;

import com.goeuro.domain.Location;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;


/**
 * Created by declan on 02/10/16.
 */
@Component
public class CsvGenerator {

    private static final Logger log = LoggerFactory.getLogger(CsvGenerator.class);
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String[] HEADINGS = {"_id", "name", "type", "latitude", "longitude"};

    public void createCsv(String city, List<Location> locations) {

        FileWriter csvFileWriter = null;
        CSVPrinter csvPrinter = null;
        try {
            File file = new File(uniqueFileName(city));
            csvFileWriter = new FileWriter(file);
            csvPrinter = new CSVPrinter(csvFileWriter, CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR));
            csvPrinter.printRecord(HEADINGS);
            locations.stream().forEach(printCsvRecord(csvPrinter));
            log.info("Csv File Created Successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            cleanUpFileHandling(city, csvFileWriter, csvPrinter);
        }

    }

    private void cleanUpFileHandling(String city, FileWriter csvFileWriter, CSVPrinter csvPrinter) {
        try {
            csvFileWriter.flush();
            csvFileWriter.close();
            csvPrinter.close();
        } catch (IOException e) {
            log.error("Error Occurred While Creating Csv File for " + city);
            throw new RuntimeException(e.getMessage());
        }
    }

    private String uniqueFileName(String city) {
        return city + "_" + UUID.randomUUID().toString() + ".csv";
    }

    private Consumer<Location> printCsvRecord(CSVPrinter csvPrinter) {
        return location -> {

            try {
                List<String> locationData = new ArrayList<String>();
                locationData.add(location.getId());
                locationData.add(location.getName());
                locationData.add(location.getType());
                locationData.add(location.getGeoLocation().getLatitude());
                locationData.add(location.getGeoLocation().getLongitude());
                csvPrinter.printRecord(locationData);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        };
    }
}
