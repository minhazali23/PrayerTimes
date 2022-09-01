package com.prayerTimes.prayerTimes.ExternalApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class AladhanApi {

    @Value("${aladhan.api.uri}")
    private String uri;


}
