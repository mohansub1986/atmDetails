package com.mohansub.atm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    private String housenumber;
    private String city;
    @JsonProperty("geoLocation")
    private Geolocation geolocation;
    private String street;
    private String postalcode;
    public void setHousenumber(String housenumber) {
         this.housenumber = housenumber;
     }
     public String getHousenumber() {
         return housenumber;
     }

    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setGeolocation(Geolocation geolocation) {
         this.geolocation = geolocation;
     }
     public Geolocation getGeolocation() {
         return geolocation;
     }

    public void setStreet(String street) {
         this.street = street;
     }
     public String getStreet() {
         return street;
     }

    public void setPostalcode(String postalcode) {
         this.postalcode = postalcode;
     }
     public String getPostalcode() {
         return postalcode;
     }

}