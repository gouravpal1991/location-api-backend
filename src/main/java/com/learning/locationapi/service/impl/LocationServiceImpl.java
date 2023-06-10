package com.learning.locationapi.service.impl;

import com.learning.locationapi.apiclient.GeoCoderApiService;
import com.learning.locationapi.entity.LocationEntity;
import com.learning.locationapi.mapper.LocationMapper;
import com.learning.locationapi.model.LocationModel;
import com.learning.locationapi.repository.LocationRepository;
import com.learning.locationapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private GeoCoderApiService geoCoderApiService;

    @Override
    public List<LocationModel> getAllLocations(Long userId) {
        List<LocationEntity> locationEntities = locationRepository.findByUserId(userId);
        List<LocationModel> locationModels = new ArrayList<>();

        Consumer<LocationModel> locationModelConsumer = model -> locationModels.add(model);
        Function<LocationEntity, LocationModel> entityToModel =
                locationEntity -> LocationMapper.INSTANCE.convertEntityToModel(locationEntity);

        locationEntities.stream()
                .map(entityToModel)
                .forEach(locationModelConsumer);

        return locationModels;
    }

    @Override
    public boolean createLocation(LocationModel locationModel) {
        geoCoderApiService.getGeoCoordinate(locationModel);
        LocationEntity locationEntity = LocationMapper.INSTANCE.convertModelToEntity(locationModel);
        LocationEntity savedLocation = locationRepository.save(locationEntity);
        if (savedLocation != null) {
            return true;
        }
        return false;
    }

    @Override
    public LocationModel updateLocation(LocationModel locationModel) {
        return null;
    }

    @Override
    public boolean deleteLocation(Long locationId) {
        return false;
    }
}
