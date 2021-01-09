package com.example.demo.controller;

import com.example.demo.dto.CreatePropertyDto;
import com.example.demo.dto.PropertyDto;
import com.example.demo.mapper.PropertyMapper;
import com.example.demo.model.Property;
import com.example.demo.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/property")
    public ResponseEntity<CreatePropertyDto> createProperty(@RequestBody CreatePropertyDto propertyDto) {
        Property property = propertyService.save(PropertyMapper.INSTANCE.toModel(propertyDto));
        return ResponseEntity.ok(PropertyMapper.INSTANCE.toCreateDto(property));
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<Void> deletePropertyById(@PathVariable UUID id) {
        propertyService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/property")
    public ResponseEntity<List<PropertyDto>> getAllProperty() {
        return ResponseEntity.ok(PropertyMapper.INSTANCE.toDto(propertyService.getAllProperty()));
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable UUID id) {
        return ResponseEntity.ok(PropertyMapper.INSTANCE.toDto(propertyService.getPropertyById(id)));
    }

}