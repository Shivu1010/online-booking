package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Inquiry;
import com.example.propertymanagement.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The InquiryService class provides service-layer functionality for managing inquiries.
 * It interacts with the InquiryRepository to perform CRUD operations related to inquiries.
 *
 * <p>This class is annotated with {@link org.springframework.stereotype.Service} to indicate
 * that it is a Spring service component. It is automatically detected and registered
 * as a bean during component scanning.</p>
 *
 * <p>This service class is responsible for handling business logic related to inquiries,
 * such as creating new inquiries and saving them to the database.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 * @see Inquiry
 * @see InquiryRepository
 */
@Service
public class InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    /**
     * Creates and saves a new inquiry to the database.
     *
     * <p>This method takes an {@link Inquiry} object as input, which contains the details
     * of the inquiry to be created. The inquiry is then saved to the database using the
     * {@link InquiryRepository#save(Object)} method.</p>
     *
     * @param inquiry The inquiry object to be created and saved. Must not be {@code null}.
     * @return The saved inquiry object, including any auto-generated fields such as the ID.
     * @throws IllegalArgumentException if the provided inquiry is {@code null}.
     * @see Inquiry
     * @see InquiryRepository#save(Object)
     */
    public Inquiry createInquiry(Inquiry inquiry) {
        if (inquiry == null) {
            throw new IllegalArgumentException("Inquiry cannot be null");
        }
        return inquiryRepository.save(inquiry);
    }
}