package com.example.propertymanagement.controller;

import com.example.propertymanagement.model.Inquiry;
import com.example.propertymanagement.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The InquiryController class is a REST controller that handles HTTP requests related to inquiries.
 * It provides an endpoint for creating a new inquiry.
 * This controller interacts with the InquiryService to perform business logic operations.
 *
 * @RestController indicates that this class is a controller where every method returns a domain object
 * instead of a view. The domain object is converted to JSON or XML and sent as the HTTP response.
 *
 * @RequestMapping("/api/inquiries") maps the base URL for all endpoints in this controller to "/api/inquiries".
 */
@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {

    /**
     * The InquiryService instance that this controller uses to interact with the inquiry data.
     * This is automatically injected by Spring's dependency injection mechanism.
     */
    @Autowired
    private InquiryService inquiryService;

    /**
     * Creates a new inquiry in the system.
     *
     * @param inquiry the Inquiry object to be created, provided in the request body as JSON or XML.
     * @return the created Inquiry object, which is automatically converted to JSON or XML and sent as the HTTP response.
     *
     * @PostMapping maps HTTP POST requests to this method. The URL for this endpoint is "/api/inquiries".
     * @RequestBody indicates that the Inquiry object is deserialized from the request body.
     */
    @PostMapping
    public Inquiry createInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.createInquiry(inquiry);
    }
}
