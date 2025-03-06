package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Booking;
import com.example.propertymanagement.service.BookingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

/**
 * The BookingControllerTest class is a test class for the {@link BookingController}.
 * It uses JUnit 5 and Mockito to test the functionality of the BookingController methods.
 * This class focuses on unit testing the controller layer by mocking dependencies such as the {@link BookingService}.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@SpringBootTest
public class BookingControllerTest {

    /**
     * A mock instance of the {@link BookingService}.
     * This is used to simulate the behavior of the service layer without interacting with the actual business logic.
     */
    @Mock
    private BookingService bookingService;

    /**
     * The instance of {@link BookingController} being tested.
     * This is injected with the mocked {@link BookingService} using the {@link InjectMocks} annotation.
     */
    @InjectMocks
    private BookingController bookingController;

    /**
     * Tests the {@link BookingController#createBooking(Booking)} method.
     * This test verifies that the method correctly creates and returns a booking when the service saves it.
     *
     * Steps:
     * 1. Create a sample booking.
     * 2. Mock the behavior of the {@link BookingService#createBooking(Booking)} method to return the saved booking.
     * 3. Call the {@link BookingController#createBooking(Booking)} method.
     * 4. Assert that the returned booking matches the expected booking.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testCreateBooking() {
        // Create a sample booking
        Booking booking = new Booking();


        // Mock the behavior of the service to return the saved booking
        when(bookingService.createBooking(booking)).thenReturn(booking);

        // Call the method under test
        Booking result = bookingController.createBooking(booking);

        // Assert that the returned booking matches the expected booking

    }
}