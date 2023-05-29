package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrayerTimeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public PrayerTimeEntity save(PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity insertPrayerTime = new PrayerTimeEntity();
        insertPrayerTime.setCityCountry(prayerTime.getCityCountry());
        insertPrayerTime.setTimezone(prayerTime.getTimezone());
        insertPrayerTime.setDate(prayerTime.getDate());
        insertPrayerTime.setPrayerTimes(prayerTime.getPrayerTimes());

        dynamoDBMapper.save(insertPrayerTime);
        return insertPrayerTime;
    }

    public PrayerTimeEntity findByCityCountry(String cityCountry){
        return dynamoDBMapper.load(PrayerTimeEntity.class, cityCountry);
    }

    public List<PrayerTimeEntity> findAll(){
        return dynamoDBMapper.scan(PrayerTimeEntity.class, new DynamoDBScanExpression());
    }

    public PrayerTimeEntity update(String cityCountry, PrayerTimeEntityDTO prayerTime){

        PrayerTimeEntity updateCityEntity = new PrayerTimeEntity();
        updateCityEntity.setCityCountry(prayerTime.getCityCountry());
        updateCityEntity.setTimezone(prayerTime.getTimezone());
        updateCityEntity.setDate(prayerTime.getDate());
        updateCityEntity.setPrayerTimes(prayerTime.getPrayerTimes());

        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
                        .build();

        dynamoDBMapper.save(updateCityEntity, dynamoDBMapperConfig);

        return updateCityEntity;
    }

    public String delete(String id){
        PrayerTimeEntity deleteThis = new PrayerTimeEntity();
        deleteThis.setCityCountry(id);
        dynamoDBMapper.delete(deleteThis);
        return "PrayerTimeEntity deleted for " + id;
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
