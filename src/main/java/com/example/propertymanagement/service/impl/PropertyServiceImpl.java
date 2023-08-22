package com.example.propertymanagement.service.impl;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.repository.PropertyRepository;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//u can put like @service or repository or configuration, THIS IS SINGLETON DESIGN PATTERN
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        //convert propertydto to propertyentity (adapter design pattern)
        PropertyEntity pe = new PropertyEntity();
                pe.setTitle(propertyDTO.getTitle());
                pe.setAddress(propertyDTO.getAddress());
                pe.setOwnerEmail(propertyDTO.getOwnerEmail());
                pe.setOwnerName(propertyDTO.getOwnerName());
                pe.setPrice(propertyDTO.getPrice());
                pe.setDescription(propertyDTO.getDescription());
        propertyRepository.save(pe);

        return null;
    }
}
