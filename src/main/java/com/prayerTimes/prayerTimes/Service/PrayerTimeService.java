package com.prayerTimes.prayerTimes.Service;

import com.prayerTimes.prayerTimes.Repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrayerTimeService {

    @Autowired
    PrayerTimeRepository prayerTimeRepository;

    //Add api class here to call

    //If city exists and within date, return DTO

    //If city doesn't exist, add it(call api) and return DTO

    //If city exists but outdated, call api, update repo, return DTO
    //public PrayerTimeEntityDTO processAndGetPrayerTime()

}