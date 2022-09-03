package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "PrayerTimesByCity")
public class PrayerTimeEntity {

    private String timezone;
    private String date;
    private String prayerTimes;

    public PrayerTimeEntity(){}

    @DynamoDBHashKey(attributeName = "timezone")
    public String getTimezone() {
        return timezone;
    }

    @DynamoDBAttribute(attributeName = "Date")
    public String getDate() {
        return date;
    }

    @DynamoDBAttribute(attributeName = "PrayerTimes")
    public String getPrayerTimes() {
        return prayerTimes;
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
        return "PrayerTimeEntity{" +
                "City=" + timezone +
                "Date=" + date +
                "PrayerTimes=" + prayerTimes +
                "}";
    }
}
