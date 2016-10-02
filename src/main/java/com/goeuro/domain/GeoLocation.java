package com.goeuro.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by declan on 02/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {
    private String latitude;
    private String longitude;

    private GeoLocation(Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public GeoLocation() {

    }

    public static Builder newGeoLocation() {
        return new Builder();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public static final class Builder {
        private String latitude;
        private String longitude;

        private Builder() {
        }

        public GeoLocation build() {
            return new GeoLocation(this);
        }

        public Builder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }
    }
}
