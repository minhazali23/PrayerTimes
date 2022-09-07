package com.prayerTimes.prayerTimes.DTO;

public class PrayerTimeEntityDTO {

    private String cityCountry;
    private String timezone;
    private String date;
    private String prayerTimes;

    public PrayerTimeEntityDTO(){}

    public PrayerTimeEntityDTO(String cityCountry, String city, String date, String prayerTimes){
        this.cityCountry = cityCountry;
        this.timezone = city;
        this.date = date;
        this.prayerTimes = prayerTimes;
    }

    public String getCityCountry() {return cityCountry;}

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

    public void setCityCountry(String cityCountry) {this.cityCountry = cityCountry;}

    @Override
    public String toString(){
        return "PrayerTimeEntityDTO{" +
                "CityCountry=" + cityCountry +
                "City=" + timezone +
                "Date=" + date +
                "PrayerTimes=" + prayerTimes +
                "}";
    }
}
