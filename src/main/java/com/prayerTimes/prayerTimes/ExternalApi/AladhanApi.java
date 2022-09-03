package com.prayerTimes.prayerTimes.ExternalApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prayerTimes.prayerTimes.ExternalApi.Pojo.AladhanMainPojo;
import com.prayerTimes.prayerTimes.ExternalApi.Pojo.Timings;
import org.json.JSONObject;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScope
public class AladhanApi {

    // Call API to get JSON obj
    String city;
    String date;
    List<String> timings;

    public List<String> extractDataAndReformat() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:\\Users\\minha\\Desktop\\Projects\\prayerTimesData.json");
        AladhanMainPojo jsonReader = mapper.readValue(file, AladhanMainPojo.class);

        this.timings = getTimings(jsonReader);
        this.city = getCity(jsonReader);
        this.date = getDate(jsonReader);

        return timings;
    }
    private String getCity(AladhanMainPojo retCity){
        return retCity.getData().get(0).getMeta().getTimezone();
    }

    private String getDate(AladhanMainPojo retDate){
        return retDate.getData().get(0).getDate().getGregorian().getDate();
    }

    private List<String> getTimings(AladhanMainPojo retTimingsByDay){

        JSONObject day = new JSONObject();

        List<String> getTimingsForMonth = new ArrayList<>();

        for(int i = 0; i < retTimingsByDay.getData().size(); i++){

            Timings thisDay = retTimingsByDay.getData().get(i).getTimings();

            day.put("Fajr", thisDay.getFajr());
            day.put("Dhuhr", thisDay.getDhuhr());
            day.put("Asr", thisDay.getAsr());
            day.put("Maghrib", thisDay.getMaghrib());
            day.put("Isha", thisDay.getIsha());
            day.put("Sunrise", thisDay.getSunrise());
            day.put("Sunset", thisDay.getSunset());

            getTimingsForMonth.add(day.toString());
        }

        return getTimingsForMonth;
    }

}
