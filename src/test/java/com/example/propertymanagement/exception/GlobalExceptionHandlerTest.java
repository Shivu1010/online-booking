package com.example.propertymanagement.exception;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The GlobalExceptionHandlerTest class is a test class for the GlobalExceptionHandler.
 * It tests the exception handling mechanism for global exceptions.
 * This class ensures that the GlobalExceptionHandler returns the correct error response with the appropriate HTTP status.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 */
@SpringBootTest
public class GlobalExceptionHandlerTest {

    /**
     * The instance of GlobalExceptionHandler being tested.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * Tests the handleGlobalException method of the GlobalExceptionHandler class.
     * This test verifies that the method returns the correct error response when a generic exception is thrown.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testHandleGlobalException() {
        // Create a sample exception
        Exception exception = new Exception("Test exception message");

        // Mock the WebRequest
        WebRequest request = mock(WebRequest.class);
        when(request.getDescription(false)).thenReturn("Test request details");

        // Call the exception handler method
        ResponseEntity<ErrorDetails> response = globalExceptionHandler.handleGlobalException(exception, request);

        // Assert that the response status is INTERNAL_SERVER_ERROR and the error details match
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Test exception message", response.getBody().getMessage());
        assertEquals("Test request details", response.getBody().getDetails());
    }
}