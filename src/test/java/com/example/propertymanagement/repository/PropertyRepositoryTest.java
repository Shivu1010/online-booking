package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The PropertyRepositoryTest class is a test class for the PropertyRepository.
 * It uses Spring Data JPA and H2 in-memory database to test the functionality of the repository layer.
 * This class focuses on testing CRUD operations for the Property entity.
 *
 * @DataJpaTest annotation is used to configure an in-memory database and enable JPA repositories for testing.
 */
@DataJpaTest
public class PropertyRepositoryTest {

    /**
     * The instance of PropertyRepository being tested.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * Tests the save method of the PropertyRepository class.
     * This test verifies that a property can be saved and retrieved from the database.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testSaveProperty() {
        // Create a sample property
        Property property = new Property();


        // Save the property to the repository
        Property savedProperty = propertyRepository.save(property);

        // Retrieve the property from the repository
        Property retrievedProperty = propertyRepository.findById(savedProperty.getId()).orElse(null);

        // Assert that the saved and retrieved property are not null and match
        assertNotNull(retrievedProperty);
        assertEquals(savedProperty.getId(), retrievedProperty.getId());

    }
}