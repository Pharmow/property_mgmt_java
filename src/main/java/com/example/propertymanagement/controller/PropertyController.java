package com.example.propertymanagement.controller;


import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PropertyController {

    //this is dependency injection
    @Autowired
    private PropertyService propertyService;


    @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){
        System.out.println(propertyDTO);
return propertyDTO;
    }
}
