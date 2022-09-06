package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PrayerTimeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public PrayerTimeEntity save(PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity insertPrayerTime = new PrayerTimeEntity();
        insertPrayerTime.setCityCountry(prayerTime.getCityCountry());
        insertPrayerTime.setTimezone(prayerTime.getTimezone());
        insertPrayerTime.setDate(prayerTime.getDate());
        insertPrayerTime.setPrayerTimes(prayerTime.getPrayerTimes().toString());

        dynamoDBMapper.save(insertPrayerTime);
        return insertPrayerTime;
    }

    public PrayerTimeEntity findByCityCountry(String cityCountry){
        return dynamoDBMapper.load(PrayerTimeEntity.class, cityCountry);
    }

    public List<PrayerTimeEntity> findAll(){
        return dynamoDBMapper.scan(PrayerTimeEntity.class, new DynamoDBScanExpression());
    }

    public PrayerTimeEntity update(String timezone, PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity updateCityEntity = new PrayerTimeEntity();
        updateCityEntity.setCityCountry(prayerTime.getCityCountry());
        updateCityEntity.setTimezone(prayerTime.getTimezone());
        updateCityEntity.setDate(prayerTime.getDate());
        updateCityEntity.setPrayerTimes(prayerTime.getPrayerTimes().toString());

        dynamoDBMapper.save(updateCityEntity,
                new DynamoDBSaveExpression()
                        .withExpectedEntry(timezone, new ExpectedAttributeValue(
                                new AttributeValue().withS(timezone)
                        )));

        return updateCityEntity;
    }

    public String delete(String id){
        dynamoDBMapper.delete(id);
        return "PrayerTimeEntity deleted for city " + id;
    }

    public PrayerTimeEntityDTO findOne(String cityCountry) {
        PrayerTimeEntityDTO retDTO = new PrayerTimeEntityDTO();

        try {
            PrayerTimeEntity entity = dynamoDBMapper.load(PrayerTimeEntity.class, cityCountry);

            retDTO.setCityCountry(entity.getCityCountry());
            retDTO.setTimezone(entity.getTimezone());
            retDTO.setDate(entity.getDate());
            retDTO.setPrayerTimes(entity.getPrayerTimes());

            return retDTO;

        }catch (NullPointerException ex){
            System.out.println(ex);
        }
        return retDTO;
    }
}
