package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Property;
import com.example.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The PropertyControllerTest class is a test class for the PropertyController.
 * It uses JUnit 5 and Mockito to test the functionality of the PropertyController methods.
 * This class focuses on unit testing the controller layer by mocking dependencies such as the PropertyService.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 */
@SpringBootTest
public class PropertyControllerTest {

    /**
     * A mock instance of the PropertyService.
     * This is used to simulate the behavior of the service layer without interacting with the actual business logic.
     */
    @Mock
    private PropertyService propertyService;

    /**
     * The instance of PropertyController being tested.
     * This is injected with the mocked PropertyService using the @InjectMocks annotation.
     */
    @InjectMocks
    private PropertyController propertyController;

    /**
     * Tests the getAllProperties method of the PropertyController class.
     * This test verifies that the method returns the correct list of properties when the service returns a list of properties.
     *
     * @Test annotation indicates that this method is a test case.
     * The test uses Mockito to mock the behavior of the PropertyService and asserts the expected result.
     */
    @Test
    public void testGetAllProperties() {
        // Create sample properties
        Property property1 = new Property();
        Property property2 = new Property();
        List<Property> properties = Arrays.asList(property1, property2);

        // Mock the behavior of the service to return the list of properties
        when(propertyService.getAllProperties()).thenReturn(properties);

        // Call the method under test
        List<Property> result = propertyController.getAllProperties();

        // Assert that the returned list matches the expected list
        assertEquals(2, result.size());
        assertEquals(properties, result);
    }

    /**
     * Tests the addProperty method of the PropertyController class.
     * This test verifies that the method correctly adds and returns a property when the service saves it.
     *
     * @Test annotation indicates that this method is a test case.
     * The test uses Mockito to mock the behavior of the PropertyService and asserts the expected result.
     */
    @Test
    public void testAddProperty() {
        // Create a sample property
        Property property = new Property();
        property.setId(1L);


        // Mock the behavior of the service to return the saved property
        when(propertyService.addProperty(property)).thenReturn(property);

        // Call the method under test
        Property result = propertyController.addProperty(property);

        // Assert that the returned property matches the expected property
        assertEquals(property.getId(), result.getId());
    }
}