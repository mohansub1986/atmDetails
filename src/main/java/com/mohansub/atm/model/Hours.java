package com.mohansub.atm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hours {

    @JsonProperty("hourFrom")
    private String hourfrom;
    @JsonProperty("hourTo")
    private String hourto;
    public void setHourfrom(String hourfrom) {
         this.hourfrom = hourfrom;
     }
     public String getHourfrom() {
         return hourfrom;
     }

    public void setHourto(String hourto) {
         this.hourto = hourto;
     }
     public String getHourto() {
         return hourto;
     }

}