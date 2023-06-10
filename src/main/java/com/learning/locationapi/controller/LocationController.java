package com.learning.locationapi.controller;

import com.learning.locationapi.model.LocationModel;
import com.learning.locationapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations/users/{userId}")
    public ResponseEntity<List<LocationModel>> getAllLocations(@PathVariable("userId") Long userId) {
        List<LocationModel> allLocations = locationService.getAllLocations(userId);
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }

    @PostMapping("/locations/users")
    public ResponseEntity<String> createLocation(@RequestBody LocationModel locationModel) {
        boolean result = locationService.createLocation(locationModel);
        if(result) {
            return new ResponseEntity<>("Location created!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Location could not be created!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/locations/{locationId}/users/{userId}")
    public void updateLocation(@PathVariable("locationId") Long locationId, @PathVariable("userId") Long userId,
                               @RequestBody LocationModel locationModel) {

    }

    @DeleteMapping("/locations/{locationId}/users/{userId}")
    public void deleteLocation(@PathVariable("locationId") Long locationId, @PathVariable("userId") Long userId,
                               @RequestBody LocationModel locationModel) {

    }
}
