package com.learning.locationapi.apiclient;

import com.learning.locationapi.model.LocationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoCoderApiService {
    private final Logger logger = LoggerFactory.getLogger(GeoCoderApiService.class);

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Value("${geocode.api.baseurl}")
    private String geocodeBaseUrl;

    @Value("${geocode.api.key}")
    private String geocodeAccessKey;

//    @Cacheable(value = "getGeoCoordinateCache", key = "#locationModel", condition = "#locationModel")
    public void getGeoCoordinate(LocationModel locationModel){
        logger.info("In getGeoCoordinate service");

        StringBuilder apiUrlBuilder = new StringBuilder(geocodeBaseUrl);
        apiUrlBuilder.append("?access_key=");
        apiUrlBuilder.append(geocodeAccessKey);
        apiUrlBuilder.append("&query=");
        apiUrlBuilder.append(locationModel.getPlotNo());
        apiUrlBuilder.append(" ");
        apiUrlBuilder.append(locationModel.getStreet());
        apiUrlBuilder.append(" ");
        apiUrlBuilder.append(locationModel.getPincode());

        try {
            GeoCoderResponseWrapper geoCoderResponseWrapper =  restTemplate.getForObject(apiUrlBuilder.toString(), GeoCoderResponseWrapper.class);
            geoCoderResponseWrapper.getData().stream().forEach(System.out::println);
            locationModel.setLat(geoCoderResponseWrapper.getData().get(0).getLatitude().toString());
            locationModel.setLat(geoCoderResponseWrapper.getData().get(0).getLongitude().toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
