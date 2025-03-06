package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Property;
import com.example.propertymanagement.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The PropertyServiceTest class is a test class for the PropertyService.
 * It uses JUnit 5 and Mockito to test the functionality of the PropertyService methods.
 * This class focuses on unit testing the service layer by mocking dependencies such as the PropertyRepository.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 */
@SpringBootTest
public class PropertyServiceTest {

    /**
     * A mock instance of the PropertyRepository.
     * This is used to simulate the behavior of the repository layer without interacting with the actual database.
     */
    @Mock
    private PropertyRepository propertyRepository;

    /**
     * The instance of PropertyService being tested.
     * This is injected with the mocked PropertyRepository using the @InjectMocks annotation.
     */
    @InjectMocks
    private PropertyService propertyService;

    /**
     * Tests the getAllProperties method of the PropertyService class.
     * This test verifies that the method returns the correct number of properties when the repository returns a list of properties.
     *
     * @Test annotation indicates that this method is a test case.
     * The test uses Mockito to mock the behavior of the PropertyRepository and asserts the expected result.
     */
    @Test
    public void testGetAllProperties() {
        // Mock the behavior of the repository to return a list of two properties
        when(propertyRepository.findAll()).thenReturn(Arrays.asList(new Property(), new Property()));

        // Call the method under test
        List<Property> properties = propertyService.getAllProperties();

        // Assert that the returned list contains the expected number of properties
        assertEquals(2, properties.size());
    }
}