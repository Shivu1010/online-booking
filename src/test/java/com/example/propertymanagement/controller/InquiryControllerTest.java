package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Inquiry;
import com.example.propertymanagement.service.InquiryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * The InquiryControllerTest class is a test class for the {@link InquiryController}.
 * It uses JUnit 5 and Mockito to test the functionality of the InquiryController methods.
 * This class focuses on unit testing the controller layer by mocking dependencies such as the {@link InquiryService}.
 *
 * @SpringBootTest annotation is used to indicate that this is a Spring Boot test class.
 * It ensures that the Spring application context is loaded for the test.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-10-01
 */
@SpringBootTest
public class InquiryControllerTest {

    /**
     * A mock instance of the {@link InquiryService}.
     * This is used to simulate the behavior of the service layer without interacting with the actual business logic.
     */
    @Mock
    private InquiryService inquiryService;

    /**
     * The instance of {@link InquiryController} being tested.
     * This is injected with the mocked {@link InquiryService} using the {@link InjectMocks} annotation.
     */
    @InjectMocks
    private InquiryController inquiryController;

    /**
     * Tests the {@link InquiryController#createInquiry(Inquiry)} method.
     * This test verifies that the method correctly creates and returns an inquiry when the service saves it.
     *
     * Steps:
     * 1. Create a sample inquiry.
     * 2. Mock the behavior of the {@link InquiryService#createInquiry(Inquiry)} method to return the saved inquiry.
     * 3. Call the {@link InquiryController#createInquiry(Inquiry)} method.
     * 4. Assert that the returned inquiry matches the expected inquiry.
     *
     * @Test annotation indicates that this method is a test case.
     */
    @Test
    public void testCreateInquiry() {
        // Create a sample inquiry
        Inquiry inquiry = new Inquiry();
        inquiry.setId(1L);
        inquiry.setPropertyId(101L);
        inquiry.setCustomerName("Jane Doe");
        inquiry.setCustomerEmail("jane.doe@example.com");
        inquiry.setMessage("I am interested in this property. Please provide more details.");

        // Mock the behavior of the service to return the saved inquiry
        when(inquiryService.createInquiry(inquiry)).thenReturn(inquiry);

        // Call the method under test
        Inquiry result = inquiryController.createInquiry(inquiry);

        // Assert that the returned inquiry matches the expected inquiry
        assertEquals(inquiry.getId(), result.getId());
        assertEquals(inquiry.getPropertyId(), result.getPropertyId());
        assertEquals(inquiry.getCustomerName(), result.getCustomerName());
        assertEquals(inquiry.getCustomerEmail(), result.getCustomerEmail());
        assertEquals(inquiry.getMessage(), result.getMessage());
    }
}