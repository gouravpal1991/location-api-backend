package com.learning.locationapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.locationapi.constant.LocationType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationModel {
    private LocationType locationType;
    private String plotNo;
    private String street;
    private String pincode;
    private String city;
    private String state;
    private String country;
    private Long userId;
    private Long openCloseTimeId;
    private Long offeringId;
    private String lat;
    private String lng;
}
