package com.prayerTimes.prayerTimes.Service;

import com.prayerTimes.prayerTimes.ExternalApi.AladhanApi;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PrayerTimeService {


    public List<String> testPojo() throws IOException {

        AladhanApi aladhanApi1 = new AladhanApi("NewYork", "UnitedStates");
        return aladhanApi1.getTimings();

    }

//    public String prayerTimesProcessor(String city, String country){};
//
//    private boolean doesCityExistAndWithinDate(){}
//
//    private boolean doesCityExist(){}






    //Add api class here to call

    //If city exists and within date, return DTO

    //If city doesn't exist, add it(call api) and return DTO

    //If city exists but outdated, call api, update repo, return DTO
    //public PrayerTimeEntityDTO processAndGetPrayerTime()

}
