package com.prayerTimes.prayerTimes.RestController;

import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import com.prayerTimes.prayerTimes.ExternalApi.AladhanApi;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeEntity;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeRepository;
import com.prayerTimes.prayerTimes.Service.PrayerTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/prayerTimes")
public class PrayerTimesRestController{

    @Autowired
    PrayerTimeRepository prayerTimeRepository;

    @Autowired
    PrayerTimeService prayerTimeService;

    @PostMapping("/addNew")
    public PrayerTimeEntity save(@RequestBody PrayerTimeEntityDTO prayerTime){
        return prayerTimeRepository.save(prayerTime);
    }

    @GetMapping("/get/{cityCountry}")
    public PrayerTimeEntity cityCountry(@PathVariable(value = "cityCountry") String cityCountry){
        return prayerTimeRepository.findByCityCountry(cityCountry);
    }

    @PutMapping("/update/{city}")
    public PrayerTimeEntity update(@PathVariable(value = "cityCountry") String cityCountry, @RequestBody PrayerTimeEntityDTO prayerTime){
        return prayerTimeRepository.update(cityCountry, prayerTime);
    }

    @DeleteMapping("/delete/{cityCountry}")
    public String delete(@PathVariable(value = "cityCountry") String cityCountry){
        return prayerTimeRepository.delete(cityCountry);
    }

    @GetMapping(value = "/testPojo")
    public List<String> testPojo() throws IOException {
        return prayerTimeService.testPojo();
    }
    @GetMapping("prayerTimeRequest/{country}/{city}")
    public PrayerTimeEntityDTO prayerTimeRequest(@PathVariable(value = "city") String city, @PathVariable(value = "country") String country) throws IOException {
        return prayerTimeService.prayerTimesProcessor(city, country);
    }
}