package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Inquiry} entities.
 * This interface extends {@link JpaRepository} to provide CRUD operations
 * and other common database interactions for the {@link Inquiry} entity.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see JpaRepository
 * @see Inquiry
 */
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}