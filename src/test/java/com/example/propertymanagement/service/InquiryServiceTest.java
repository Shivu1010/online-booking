package com.example.propertymanagement.service;

import com.example.propertymanagement.model.Inquiry;
import com.example.propertymanagement.repository.InquiryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The InquiryServiceTest class is a test class for the InquiryService.
 * It uses JUnit 5 and Mockito to test the functionality of the InquiryService methods.
 * This class focuses on unit testing the service layer by mocking dependencies such as the InquiryRepository.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 */
@SpringBootTest
public class InquiryServiceTest {

    /**
     * A mock instance of the InquiryRepository.
     * This is used to simulate the behavior of the repository layer without interacting with the actual database.
     */
    @Mock
    private InquiryRepository inquiryRepository;

    /**
     * The instance of InquiryService being tested.
     * This is injected with the mocked InquiryRepository using the @InjectMocks annotation.
     */
    @InjectMocks
    private InquiryService inquiryService;

    /**
     * Tests the createInquiry method of the InquiryService class.
     * This test verifies that the method correctly creates and returns an inquiry when the repository saves it.
     *
     * @Test annotation indicates that this method is a test case.
     * The test uses Mockito to mock the behavior of the InquiryRepository and asserts the expected result.
     */
    @Test
    public void testCreateInquiry() {
        // Create a sample inquiry object
        Inquiry inquiry = new Inquiry();
        inquiry.setId(1L);
        inquiry.setPropertyId(101L);
        inquiry.setMessage("Test inquiry message");

        // Mock the behavior of the repository to return the saved inquiry
        when(inquiryRepository.save(inquiry)).thenReturn(inquiry);

        // Call the method under test
        Inquiry createdInquiry = inquiryService.createInquiry(inquiry);

        // Assert that the returned inquiry matches the expected inquiry
        assertEquals(inquiry.getId(), createdInquiry.getId());
        assertEquals(inquiry.getPropertyId(), createdInquiry.getPropertyId());
        assertEquals(inquiry.getMessage(), createdInquiry.getMessage());
    }
}