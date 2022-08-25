package com.prayerTimes.prayerTimes.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrayerTimeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public PrayerTimeEntity save(PrayerTimeEntity prayerTime){
        dynamoDBMapper.save(prayerTime);
        return prayerTime;
    }

    public PrayerTimeEntity findByCity(String city){
        return dynamoDBMapper.load(PrayerTimeEntity.class, city);
    }

    public List<PrayerTimeEntity> findAll(){
        return dynamoDBMapper.scan(PrayerTimeEntity.class, new DynamoDBScanExpression());
    }

    public PrayerTimeEntity update(String city, PrayerTimeEntity prayerTime){
        dynamoDBMapper.save(prayerTime,
                new DynamoDBSaveExpression()
                        .withExpectedEntry(city, new ExpectedAttributeValue(
                                new AttributeValue().withS(city)
                        )));

        return prayerTime;
    }

    public String delete(String id){
        dynamoDBMapper.delete(id);
        return "PrayerTimeEntity deleted for city " + id;
    }
}
