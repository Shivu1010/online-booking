package com.example.propertymanagement.repository;

import com.example.propertymanagement.model.Inquiry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The InquiryRepositoryTest class is a test class for the InquiryRepository.
 * It uses Spring Data JPA and H2 in-memory database to test the functionality of the repository layer.
 * This class focuses on testing CRUD operations for the Inquiry entity.
 *
 * @DataJpaTest annotation is used to configure an in-memory database and enable JPA repositories for testing.
 */
@DataJpaTest
public class InquiryRepositoryTest {

    /**
     * The instance of InquiryRepository being tested.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private InquiryRepository inquiryRepository;

    /**
     * Tests the save method of the InquiryRepository class.
     * This test verifies that an inquiry can be saved and retrieved from the database.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testSaveInquiry() {
        // Create a sample inquiry
        Inquiry inquiry = new Inquiry();
        inquiry.setPropertyId(101L);
        inquiry.setMessage("Test inquiry message");

        // Save the inquiry to the repository
        Inquiry savedInquiry = inquiryRepository.save(inquiry);

        // Retrieve the inquiry from the repository
        Inquiry retrievedInquiry = inquiryRepository.findById(savedInquiry.getId()).orElse(null);

        // Assert that the saved and retrieved inquiry are not null and match
        assertNotNull(retrievedInquiry);
        assertEquals(savedInquiry.getId(), retrievedInquiry.getId());
        assertEquals(savedInquiry.getPropertyId(), retrievedInquiry.getPropertyId());
        assertEquals(savedInquiry.getMessage(), retrievedInquiry.getMessage());
    }
}