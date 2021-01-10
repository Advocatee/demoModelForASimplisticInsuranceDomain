package com.example.demo.mapper;

import com.example.demo.dto.CreatePropertyDto;
import com.example.demo.dto.PropertyDto;
import com.example.demo.model.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ClientMapper.class})
public interface PropertyMapper {

    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    PropertyDto toDto(Property property);

    Property toModel(CreatePropertyDto propertyDto);

    @Mapping(source = "id", target = "id")
    CreatePropertyDto toCreateDto(Property property);

    List<PropertyDto> toDto(List<Property> properties);

}
