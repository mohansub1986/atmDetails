package com.mohansub.atm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRootBean {

    private Address address;
    private int distance;
    @JsonProperty("openingHours")
    private List<Openinghours> openinghours;
    private String functionality;
    private String type;
    public void setAddress(Address address) {
         this.address = address;
     }
     public Address getAddress() {
         return address;
     }

    public void setDistance(int distance) {
         this.distance = distance;
     }
     public int getDistance() {
         return distance;
     }

    public void setOpeninghours(List<Openinghours> openinghours) {
         this.openinghours = openinghours;
     }
     public List<Openinghours> getOpeninghours() {
         return openinghours;
     }

    public void setFunctionality(String functionality) {
         this.functionality = functionality;
     }
     public String getFunctionality() {
         return functionality;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}