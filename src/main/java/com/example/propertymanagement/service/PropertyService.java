package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Property;
import com.example.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing {@link Property} entities.
 * This class provides business logic and operations related to properties,
 * such as retrieving all properties and adding new properties.
 * <p>
 * It interacts with the {@link PropertyRepository} to perform database operations
 * and acts as a bridge between the controller layer and the repository layer.
 * </p>
 * <p>
 * This class is annotated with {@link org.springframework.stereotype.Service} to indicate
 * that it is a Spring-managed service component.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see Property
 * @see PropertyRepository
 * @see org.springframework.stereotype.Service
 */
@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * Retrieves a list of all properties from the database.
     * <p>
     * This method uses the {@link PropertyRepository#findAll()} method to fetch
     * all properties stored in the database.
     * </p>
     *
     * @return a list of all {@link Property} entities.
     * @see PropertyRepository#findAll()
     */
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    /**
     * Adds a new property to the database.
     * <p>
     * This method uses the {@link PropertyRepository#save(Object)} method to persist
     * the provided {@link Property} entity in the database.
     * </p>
     *
     * @param property the {@link Property} entity to be added.
     * @return the saved {@link Property} entity, including any auto-generated fields (e.g., ID).
     * @see PropertyRepository#save(Object)
     */
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }
}