package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Property} entities.
 * This interface extends {@link JpaRepository} to provide CRUD operations
 * and other common database interactions for the {@link Property} entity.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {
}