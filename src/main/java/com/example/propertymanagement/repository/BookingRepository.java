package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Booking} entities.
 * This interface extends {@link JpaRepository} to provide CRUD operations
 * and other common database interactions for the {@link Booking} entity.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see JpaRepository
 * @see Booking
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
}