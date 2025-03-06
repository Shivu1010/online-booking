package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Booking;
import com.example.propertymanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * The BookingController class is a REST controller that handles HTTP requests related to bookings.
 * It provides an endpoint for creating a new booking.
 * This controller interacts with the BookingService to perform business logic operations.
 *
 * @RestController indicates that this class is a controller where every method returns a domain object
 * instead of a view. The domain object is converted to JSON or XML and sent as the HTTP response.
 *
 * @RequestMapping("/api/bookings") maps the base URL for all endpoints in this controller to "/api/bookings".
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    /**
     * The BookingService instance that this controller uses to interact with the booking data.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private BookingService bookingService;

    /**
     * Creates a new booking in the system.
     *
     * @param booking the Booking object to be created, provided in the request body as JSON or XML.
     * @return the created Booking object, which is automatically converted to JSON or XML and sent as the HTTP response.
     *
     * @PostMapping maps HTTP POST requests to this method. The URL for this endpoint is "/api/bookings".
     * @RequestBody indicates that the Booking object is deserialized from the request body.
     */
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}