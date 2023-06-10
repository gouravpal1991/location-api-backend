package com.learning.locationapi.repository;

import com.learning.locationapi.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
    List<LocationEntity> findByUserId(Long userId);
}
