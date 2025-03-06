package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The BookingRepositoryTest class is a test class for the BookingRepository.
 * It uses Spring Data JPA and H2 in-memory database to test the functionality of the repository layer.
 * This class focuses on testing CRUD operations for the Booking entity.
 *
 * @DataJpaTest annotation is used to configure an in-memory database and enable JPA repositories for testing.
 */
@DataJpaTest
public class BookingRepositoryTest {

    /**
     * The instance of BookingRepository being tested.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Tests the save method of the BookingRepository class.
     * This test verifies that a booking can be saved and retrieved from the database.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testSaveBooking() {
        // Create a sample booking
        Booking booking = new Booking();
        booking.setPropertyId(101L);


        // Save the booking to the repository
        Booking savedBooking = bookingRepository.save(booking);

        // Retrieve the booking from the repository
        Booking retrievedBooking = bookingRepository.findById(savedBooking.getId()).orElse(null);

        // Assert that the saved and retrieved booking are not null and match
        assertNotNull(retrievedBooking);
        assertEquals(savedBooking.getId(), retrievedBooking.getId());
        assertEquals(savedBooking.getPropertyId(), retrievedBooking.getPropertyId());

    }
}