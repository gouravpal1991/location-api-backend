package com.learning.locationapi.mapper;

import com.learning.locationapi.entity.LocationEntity;
import com.learning.locationapi.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationMapper {
    LocationMapper INSTANCE= Mappers.getMapper(LocationMapper.class);

    LocationEntity convertModelToEntity(LocationModel locationModel);
    LocationModel convertEntityToModel(LocationEntity locationEntity);

}
