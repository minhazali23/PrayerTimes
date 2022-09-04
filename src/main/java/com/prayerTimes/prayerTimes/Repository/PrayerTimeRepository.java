package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrayerTimeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public PrayerTimeEntity save(PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity insertPrayerTime = new PrayerTimeEntity();
        insertPrayerTime.setTimezone(prayerTime.getTimezone());
        insertPrayerTime.setDate(prayerTime.getDate());
        insertPrayerTime.setPrayerTimes(prayerTime.getPrayerTimes());

        dynamoDBMapper.save(insertPrayerTime);
        return insertPrayerTime;
    }

    public PrayerTimeEntity findByCity(String city){
        return dynamoDBMapper.load(PrayerTimeEntity.class, city);
    }

    public List<PrayerTimeEntity> findAll(){
        return dynamoDBMapper.scan(PrayerTimeEntity.class, new DynamoDBScanExpression());
    }

    public PrayerTimeEntity update(String city, PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity updateCityEntity = new PrayerTimeEntity();
        updateCityEntity.setTimezone(prayerTime.getTimezone());
        updateCityEntity.setDate(prayerTime.getDate());
        updateCityEntity.setPrayerTimes(prayerTime.getPrayerTimes());

        dynamoDBMapper.save(updateCityEntity,
                new DynamoDBSaveExpression()
                        .withExpectedEntry(city, new ExpectedAttributeValue(
                                new AttributeValue().withS(city)
                        )));

        return updateCityEntity;
    }

    public String delete(String id){
        dynamoDBMapper.delete(id);
        return "PrayerTimeEntity deleted for city " + id;
    }

    public PrayerTimeEntityDTO findOne(String timezone){

        PrayerTimeEntityDTO retDTO = new PrayerTimeEntityDTO();
        PrayerTimeEntity entity = dynamoDBMapper.load(PrayerTimeEntity.class, timezone);

        retDTO.setTimezone(entity.getTimezone());
        retDTO.setDate(entity.getDate());
        retDTO.setPrayerTimes(entity.getPrayerTimes());

        return retDTO;
    }
}
