package com.example.demo.service;

import com.example.demo.model.Property;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    Property save(Property property);

    Property getPropertyById(UUID id);

    void removeById(UUID id);

    List<Property> getAllProperty();

}
