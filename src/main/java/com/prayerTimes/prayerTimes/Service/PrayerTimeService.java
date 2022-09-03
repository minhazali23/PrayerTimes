package com.prayerTimes.prayerTimes.Service;

import com.prayerTimes.prayerTimes.ExternalApi.AladhanApi;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PrayerTimeService {

    public List<String> testPojo() throws IOException {

        AladhanApi aladhanApi1 = new AladhanApi("London", "UnitedKingdom");
//        aladhanApi1.extractDataAndReformat();
        return aladhanApi1.getTimings();

    }

    //Add api class here to call

    //If city exists and within date, return DTO

    //If city doesn't exist, add it(call api) and return DTO

    //If city exists but outdated, call api, update repo, return DTO
    //public PrayerTimeEntityDTO processAndGetPrayerTime()

}
