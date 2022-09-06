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
import java.util.Objects;

@Service
public class PrayerTimeService {

    @Autowired
    PrayerTimeRepository prayerTimeRepository;

    @Autowired
    AladhanApi aladhanApi;

    public PrayerTimeEntityDTO testPojo() throws IOException {

        PrayerTimeEntityDTO prayerTimeEntityDTO = new PrayerTimeEntityDTO();
        prayerTimeEntityDTO.setCityCountry("TokyoJapan");
        prayerTimeEntityDTO.setDate("newdate");
        prayerTimeEntityDTO.setTimezone("newTimezone");
        prayerTimeEntityDTO.setPrayerTimes("newTime");

        prayerTimeRepository.update(prayerTimeEntityDTO.getCityCountry(), prayerTimeEntityDTO);
        return prayerTimeEntityDTO;
    }

    public PrayerTimeEntityDTO prayerTimesProcessor(String city, String country) throws IOException {

            String cityCountry = city.concat(country);
            PrayerTimeEntityDTO prayerTimeEntityDTO;
            prayerTimeEntityDTO = prayerTimeRepository.findOne(cityCountry);

            if (Objects.isNull(prayerTimeEntityDTO.getCityCountry())) {
                prayerTimeEntityDTO = callApiAndGetPrayerTimeDTO(city, country);
                prayerTimeRepository.save(prayerTimeEntityDTO);
            }

            if (!isTheDateUpToDate(prayerTimeEntityDTO.getDate())) {
                prayerTimeEntityDTO = callApiAndGetPrayerTimeDTO(city, country);
                prayerTimeRepository.update(city, prayerTimeEntityDTO);
            }

            return prayerTimeEntityDTO;
    }

    private PrayerTimeEntityDTO callApiAndGetPrayerTimeDTO(String city, String country) throws IOException {

        String cityCountry = city.concat(country);
        PrayerTimeEntityDTO retPrayerTimeEntityDTO = new PrayerTimeEntityDTO();
        AladhanApi getAladhanApi = new AladhanApi(city, country);

        retPrayerTimeEntityDTO.setCityCountry(cityCountry);
        retPrayerTimeEntityDTO.setPrayerTimes(getAladhanApi.getTimings().toString());
        retPrayerTimeEntityDTO.setTimezone(getAladhanApi.getTimezone());
        retPrayerTimeEntityDTO.setDate(getAladhanApi.getDate());

        return retPrayerTimeEntityDTO;
    }


    private boolean isTheDateUpToDate(String thisDate){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(thisDate, formatter);

        if(LocalDate.now().getMonth().compareTo(date.getMonth()) != 0)
            return false;

        return true;
    }

}
