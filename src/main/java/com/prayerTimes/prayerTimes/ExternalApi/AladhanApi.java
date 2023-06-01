package com.prayerTimes.prayerTimes.ExternalApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prayerTimes.prayerTimes.ExternalApi.Pojo.AladhanMainPojo;
import com.prayerTimes.prayerTimes.ExternalApi.Pojo.Timings;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@RequestScope
@Component
public class AladhanApi {

    String timezone;
    String date;
    List<String> timings;

    public AladhanApi(String cityRequest, String countryRequest) throws IOException {
        this.callApiAndFormatJson(cityRequest,countryRequest);
    }

    public void callApiAndFormatJson(String city, String country) throws IOException {

        String getJsonFromRequest = consumeExternalApiAndGetJson(city, country);
        extractDataAndReformat(getJsonFromRequest);
    }

    public String consumeExternalApiAndGetJson(String city, String country) throws UnsupportedEncodingException {

        String returnJson = null;
        String cityEncoded = URLEncoder.encode(city, "UTF-8");
        String countryEncoded = URLEncoder.encode(country, "UTF-8");
        String uri = "https://api.aladhan.com/v1/calendarByCity?city=".concat(cityEncoded).concat("&country=").concat(countryEncoded).concat("&method=2");

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(uri);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            if(response.getStatusLine().getStatusCode() != 200){
                throw new RuntimeException("Failed with error code: " + response.getStatusLine().getStatusCode());
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent()))
            );

            returnJson = bufferedReader.lines().collect(Collectors.joining());

        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return returnJson;
    }


    public void extractDataAndReformat(String jsonFromApi) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        AladhanMainPojo jsonReader = mapper.readValue(jsonFromApi, AladhanMainPojo.class);

        this.timings = getTimingsFromJson(jsonReader);
        this.timezone = getTimeZoneFromJson(jsonReader);
        this.date = getDateFromJson(jsonReader);

    }
    private String getTimeZoneFromJson(AladhanMainPojo retTimeZone){

        String extractTimeZone = retTimeZone.getData().get(0).getTimings().getFajr();
        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(extractTimeZone);
        if(matcher.find()) {
            return matcher.group(0);
        }
        return "no timezone found";
    }

    private String getDateFromJson(AladhanMainPojo retDate){
        return retDate.getData().get(0).getDate().getGregorian().getDate();
    }

    private List<String> getTimingsFromJson(AladhanMainPojo retTimingsByDay){

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

    public String getDate() {
        return date;
    }

    public String getTimezone() {
        return timezone;
    }

    public List<String> getTimings() {
        return timings;
    }
}
