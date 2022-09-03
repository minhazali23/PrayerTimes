package com.prayerTimes.prayerTimes.DTO;

public class PrayerTimeEntityDTO {

    private String timezone;
    private String date;
    private String prayerTimes;

    public PrayerTimeEntityDTO(){}

    public PrayerTimeEntityDTO(String city, String date, String prayerTimes){
        this.timezone = city;
        this.date = date;
        this.prayerTimes = prayerTimes;
    }

    public String getPrayerTimes() {
        return prayerTimes;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getDate() {
        return date;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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
                "City=" + timezone +
                "Date=" + date +
                "PrayerTimes=" + prayerTimes +
                "}";
    }
}
