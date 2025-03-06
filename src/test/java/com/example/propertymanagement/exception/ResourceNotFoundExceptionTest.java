package com.example.propertymanagement.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The ResourceNotFoundExceptionTest class is a test class for the ResourceNotFoundException.
 * It tests the behavior of the custom exception, ensuring that the exception message is correctly set and retrieved.
 */
public class ResourceNotFoundExceptionTest {

    /**
     * Tests the constructor of the ResourceNotFoundException class.
     * This test verifies that the exception message is correctly set and can be retrieved.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testResourceNotFoundException() {
        // Define the expected error message
        String errorMessage = "Resource not found";

        // Create an instance of ResourceNotFoundException
        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Assert that the exception message matches the expected message
        assertEquals(errorMessage, exception.getMessage());
    }
}