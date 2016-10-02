package com.goeuro.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by declan on 02/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String id;
    private String key;
    private String name;
    private String fullName;
    private String iataAirportCode;
    private String location;
    private String country;
    private GeoLocation geoLocation;
    private String locationId;
    private boolean inEurope;
    private String countryCode;
    private boolean coreCountry;
    private String distance;
    private String type;

    private Location(Builder builder) {
        this.id = builder.id;
        this.key = builder.key;
        this.name = builder.name;
        this.fullName = builder.fullName;
        this.iataAirportCode = builder.iataAirportCode;
        this.location = builder.location;
        this.country = builder.country;
        this.geoLocation = builder.geoLocation;
    }

    public static Builder newLocation() {
        return new Builder();
    }


    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIataAirportCode() {
        return iataAirportCode;
    }

    @JsonProperty("iata_airport_code")
    public void setIataAirportCode(String iataAirportCode) {
        this.iataAirportCode = iataAirportCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    @JsonProperty("geo_position")
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getLocationId() {
        return locationId;
    }

    @JsonProperty("location_id")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        return fullName.equals(location.fullName);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public static final class Builder {
        private String id;
        private String key;
        private String name;
        private String fullName;
        private String iataAirportCode;
        private String location;
        private String country;
        private GeoLocation geoLocation;

        private Builder() {
        }

        public Location build() {
            return new Location(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder iataAirportCode(String iataAirportCode) {
            this.iataAirportCode = iataAirportCode;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder geoLocation(GeoLocation geoLocation) {
            this.geoLocation = geoLocation;
            return this;
        }
    }
}
