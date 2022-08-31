package com.prayerTimes.prayerTimes.DTO;

public class PrayerTimeEntityDTO {

    private String city;
    private String date;
    private String prayerTimes;

    public PrayerTimeEntityDTO(){}

    public PrayerTimeEntityDTO(String city, String date, String prayerTimes){
        this.city = city;
        this.date = date;
        this.prayerTimes = prayerTimes;
    }

    public String getPrayerTimes() {
        return prayerTimes;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrayerTimes(String prayerTimes) {
        this.prayerTimes = prayerTimes;
    }

    @Override
    public String toString(){
        return "PrayerTimeEntityDTO{" +
                "City=" + city +
                "Date=" + date +
                "PrayerTimes=" + prayerTimes +
                "}";
    }
}
