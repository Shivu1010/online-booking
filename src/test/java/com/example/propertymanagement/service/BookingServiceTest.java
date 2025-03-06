package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Booking;
import com.example.propertymanagement.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The BookingServiceTest class is a test class for the BookingService.
 * It uses JUnit 5 and Mockito to test the functionality of the BookingService methods.
 * This class focuses on unit testing the service layer by mocking dependencies such as the BookingRepository.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 */
@SpringBootTest
public class BookingServiceTest {

    /**
     * A mock instance of the BookingRepository.
     * This is used to simulate the behavior of the repository layer without interacting with the actual database.
     */
    @Mock
    private BookingRepository bookingRepository;

    /**
     * The instance of BookingService being tested.
     * This is injected with the mocked BookingRepository using the @InjectMocks annotation.
     */
    @InjectMocks
    private BookingService bookingService;

    /**
     * Tests the createBooking method of the BookingService class.
     * This test verifies that the method correctly creates and returns a booking when the repository saves it.
     *
     * @Test annotation indicates that this method is a test case.
     * The test uses Mockito to mock the behavior of the BookingRepository and asserts the expected result.
     */
    @Test
    public void testCreateBooking() {
        // Create a sample booking object
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setPropertyId(101L);


        // Mock the behavior of the repository to return the saved booking
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Call the method under test
        Booking createdBooking = bookingService.createBooking(booking);

        // Assert that the returned booking matches the expected booking
        assertEquals(booking.getId(), createdBooking.getId());
        assertEquals(booking.getPropertyId(), createdBooking.getPropertyId());
    }
}