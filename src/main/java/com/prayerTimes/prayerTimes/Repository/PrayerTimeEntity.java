package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "PrayerTimesByCity")
public class PrayerTimeEntity {

    private String city;
    private String date;
    private String PrayerTimes;

    public PrayerTimeEntity(){

    }

    @DynamoDBHashKey(attributeName = "City")
    public String getCity() {
        return city;
    }

    @DynamoDBAttribute(attributeName = "Date")
    public String getDate() {
        return date;
    }

    @DynamoDBAttribute(attributeName = "PrayerTimes")
    public String getPrayerTimes() {
        return PrayerTimes;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPrayerTimes(String prayerTimes) {
        PrayerTimes = prayerTimes;
    }
}
