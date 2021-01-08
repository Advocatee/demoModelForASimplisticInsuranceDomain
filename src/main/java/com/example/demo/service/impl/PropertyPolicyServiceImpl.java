package com.example.demo.service.impl;

import com.example.demo.model.PropertyPolicy;
import com.example.demo.repository.PropertyPolicyRepository;
import com.example.demo.service.PropertyPolicyService;
import org.springframework.stereotype.Service;

@Service
public class PropertyPolicyServiceImpl implements PropertyPolicyService {

    private final PropertyPolicyRepository propertyPolicyRepository;

    public PropertyPolicyServiceImpl(PropertyPolicyRepository propertyPolicyRepository) {
        this.propertyPolicyRepository = propertyPolicyRepository;
    }


    @Override
    public PropertyPolicy save(PropertyPolicy propertyPolicy) {
        return propertyPolicyRepository.save(propertyPolicy);
    }
}
