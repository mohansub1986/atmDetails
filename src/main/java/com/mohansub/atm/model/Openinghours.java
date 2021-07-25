package com.mohansub.atm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Openinghours {

    private List<Hours> hours;
    @JsonProperty("dayOfWeek")
    private int dayofweek;
    public void setHours(List<Hours> hours) {
         this.hours = hours;
     }
     public List<Hours> getHours() {
         return hours;
     }

    public void setDayofweek(int dayofweek) {
         this.dayofweek = dayofweek;
     }
     public int getDayofweek() {
         return dayofweek;
     }

}