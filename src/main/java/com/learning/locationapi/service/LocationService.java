package com.learning.locationapi.service;

import com.learning.locationapi.model.LocationModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocationService {
    List<LocationModel> getAllLocations(Long userId);
    boolean createLocation(LocationModel locationModel);

    LocationModel updateLocation(LocationModel locationModel);

    boolean deleteLocation(Long locationId);
}
