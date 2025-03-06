package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Booking;
import com.example.propertymanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing {@link Booking} entities.
 * This class provides business logic and operations related to bookings,
 * such as creating new bookings.
 * <p>
 * It interacts with the {@link BookingRepository} to perform database operations
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
 * @see Booking
 * @see BookingRepository
 * @see org.springframework.stereotype.Service
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Creates and saves a new booking to the database.
     * <p>
     * This method uses the {@link BookingRepository#save(Object)} method to persist
     * the provided {@link Booking} entity in the database.
     * </p>
     *
     * @param booking the {@link Booking} entity to be created and saved.
     * @return the saved {@link Booking} entity, including any auto-generated fields (e.g., ID).
     * @see BookingRepository#save(Object)
     */
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}