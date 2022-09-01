package com.prayerTimes.prayerTimes.RestController;

import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import com.prayerTimes.prayerTimes.ExternalApi.AladhanApi;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeEntity;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prayerTimes")
public class PrayerTimesRestController{

    @Autowired
    PrayerTimeRepository prayerTimeRepository;

    @PostMapping("/addNew")
    public PrayerTimeEntity save(@RequestBody PrayerTimeEntityDTO prayerTime){
        return prayerTimeRepository.save(prayerTime);
    }

    @GetMapping("/get/{city}")
    public PrayerTimeEntity findByCity(@PathVariable(value = "city") String city){
        return prayerTimeRepository.findByCity(city);
    }

    @GetMapping("/get/all")
    public List<PrayerTimeEntity> listAll(){
        return prayerTimeRepository.findAll();
    }

    @PutMapping("/update/{city}")
    public PrayerTimeEntity update(@PathVariable(value = "city") String city, @RequestBody PrayerTimeEntityDTO prayerTime){
        return prayerTimeRepository.update(city, prayerTime);
    }

    @DeleteMapping("/delete/{city}")
    public String delete(@PathVariable(value = "city") String city){
        return prayerTimeRepository.delete(city);
    }

    @GetMapping(value = "/testMap")
    public String testcall(){
        return "testString";
    }


}