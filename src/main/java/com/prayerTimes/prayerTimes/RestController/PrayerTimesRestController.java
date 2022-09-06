package com.prayerTimes.prayerTimes.RestController;

import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import com.prayerTimes.prayerTimes.Service.PrayerTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/prayerTimes")
public class PrayerTimesRestController{

    @Autowired
    PrayerTimeService prayerTimeService;

    @GetMapping(value = "/testPojo")
    public PrayerTimeEntityDTO testPojo() throws IOException {
        return prayerTimeService.testPojo();
    }
    @GetMapping("prayerTimeRequest/{country}/{city}")
    public PrayerTimeEntityDTO prayerTimeRequest(@PathVariable(value = "city") String city, @PathVariable(value = "country") String country) throws IOException {
        return prayerTimeService.prayerTimesProcessor(city, country);
    }
}