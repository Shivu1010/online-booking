package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Property;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The PropertyController class is a REST controller that handles HTTP requests related to properties.
        * It provides endpoints for retrieving all properties and adding a new property.
 * This controller interacts with the PropertyService to perform business logic operations.
 *
         * @RestController indicates that this class is a controller where every method returns a domain object
 * instead of a view. The domain object is converted to JSON or XML and sent as the HTTP response.
 *
         * @RequestMapping("/api/properties") maps the base URL for all endpoints in this controller to "/api/properties".
        */
@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    /**
     * The PropertyService instance that this controller uses to interact with the property data.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private PropertyService propertyService;

    /**
     * Retrieves a list of all properties.
     *
     * @return a List of Property objects representing all properties in the system.
     * The list is automatically converted to JSON or XML and sent as the HTTP response.
     *
     * @GetMapping maps HTTP GET requests to this method. The URL for this endpoint is "/api/properties".
     */
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    /**
     * Adds a new property to the system.
     *
     * @param property the Property object to be added, provided in the request body as JSON or XML.
     * @return the added Property object, which is automatically converted to JSON or XML and sent as the HTTP response.
     *
     * @PostMapping maps HTTP POST requests to this method. The URL for this endpoint is "/api/properties".
     * @RequestBody indicates that the Property object is deserialized from the request body.
     */
    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }
}