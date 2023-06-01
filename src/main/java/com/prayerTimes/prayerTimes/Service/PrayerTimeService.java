package com.prayerTimes.prayerTimes.Service;

import com.prayerTimes.prayerTimes.DTO.PrayerTimeEntityDTO;
import com.prayerTimes.prayerTimes.ExternalApi.AladhanApi;
import com.prayerTimes.prayerTimes.Repository.PrayerTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;


@Service
public class PrayerTimeService {

    @Autowired
    PrayerTimeRepository prayerTimeRepository;

    @Autowired
    AladhanApi aladhanApi;

    public PrayerTimeEntityDTO prayerTimesProcessor(String city, String country) throws IOException {

        PrayerTimeEntityDTO prayerTimeEntityDTO;

        String timeZone = convertCityCountryToTimeZone(city, country);
        PrayerTimeEntityDTO getPrayerTimeDTO = prayerTimeRepository.findOne(timeZone);

        if (!doesThisTimeZoneEntryExist(getPrayerTimeDTO)) {
            prayerTimeEntityDTO = callApiAndGetPrayerTimeDTO(city, country);
            prayerTimeRepository.save(prayerTimeEntityDTO);
        }

        else if (!isTheDateUpToDate(getPrayerTimeDTO.getDate())) {
            prayerTimeEntityDTO = callApiAndGetPrayerTimeDTO(city, country);
            prayerTimeRepository.update(city, prayerTimeEntityDTO);
        }

        return getPrayerTimeDTO;
    }

    private PrayerTimeEntityDTO callApiAndGetPrayerTimeDTO(String city, String country) throws IOException {

        PrayerTimeEntityDTO retPrayerTimeEntityDTO = new PrayerTimeEntityDTO();
        AladhanApi getAladhanApi = new AladhanApi(city, country);

        retPrayerTimeEntityDTO.setPrayerTimes(getAladhanApi.getTimings().toString());
        retPrayerTimeEntityDTO.setTimezone(getAladhanApi.getTimezone());
        retPrayerTimeEntityDTO.setDate(getAladhanApi.getDate());

        return retPrayerTimeEntityDTO;
    }


    private boolean isTheDateUpToDate(String thisDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(thisDate, formatter);

        if (LocalDate.now().getMonth().compareTo(date.getMonth()) != 0)
            return false;

        return true;
    }

    private boolean doesThisTimeZoneEntryExist(PrayerTimeEntityDTO prayerTimeEntityDTO){
        if(prayerTimeEntityDTO.getDate() == null & prayerTimeEntityDTO.getPrayerTimes() == null && prayerTimeEntityDTO.getPrayerTimes() == null)
            return false;

        return true;
    }

    //Implement DayLight savings
    private String convertCityCountryToTimeZone(String city, String country){
        String timezone = country.concat("/").concat(city);
        TimeZone tz = TimeZone.getTimeZone(timezone);
        return tz.getDisplayName(false, TimeZone.SHORT);
    }

}
