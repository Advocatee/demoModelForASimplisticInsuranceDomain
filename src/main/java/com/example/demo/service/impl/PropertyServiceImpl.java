package com.example.demo.service.impl;

import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(UUID id) {
        return propertyRepository.getOne(id);
    }

    @Override
    public void removeById(UUID id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }
}
