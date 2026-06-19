package Razorpay.paymentlink.Controller;


import Razorpay.paymentlink.DTOs.PaymentLinkFetchItemDto;
//import Razorpay.paymentlink.DTOs.PaymentLinkListResponseDto;
//import Razorpay.paymentlink.DTOs.PaymentLinkNotifyD;
import Razorpay.paymentlink.DTOs.PaymentLinkRequest;
import Razorpay.paymentlink.DTOs.PaymentLinkResponse;
import Razorpay.paymentlink.Entity.Payments.PaymentLink;
import Razorpay.paymentlink.Entity.Payments.PaymentLinkk;
//import Razorpay.paymentlink.Entity.Payments.PaymentLinkk;
import Razorpay.paymentlink.Service.PaymentLinkService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment-links")
@RequiredArgsConstructor // Automatically injects PaymentLinkService via constructor injection
public class PaymentLinkController {

    //private static final PaymentLinkk PaymentLinkk = null;
    private final PaymentLinkService paymentLinkService;

     @PostMapping
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@RequestBody PaymentLinkRequest request) {
        PaymentLinkResponse response = paymentLinkService.createStandardPaymentLink(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllPaymentLinks(
            @RequestParam(value = "reference_id", required = false) String referenceId) {
        
        List<PaymentLink> links = paymentLinkService.getAllPaymentLinks(referenceId);
        
        Map<String, Object> response = new HashMap<>();
        response.put("payment_links", links);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 

// --- New Endpoint: Fetch Single Item with Path Variable ---
    @GetMapping("/{id}")
    public ResponseEntity<PaymentLinkFetchItemDto> getPaymentLinkById(@PathVariable("id") String plinkId) {
        
        // 1. Fetch single entity from our validated business layer
        PaymentLink entity = paymentLinkService.getPaymentLinkById(plinkId);
        
        // 2. Map directly into our clean, annotation-free camelCase DTO
        PaymentLinkFetchItemDto responseDto = new PaymentLinkFetchItemDto(entity);
        
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }*/
   // --- Fixed Endpoint: Fetch Single Item with Path Variable ---
@GetMapping("/{id}")
public ResponseEntity<?> getPaymentLinkById(@PathVariable("id") String plinkId) {
    try {
        // 1. Fetch the raw core entity from your service layer
        PaymentLink entity = paymentLinkService.getPaymentLinkById(plinkId);
        
        // 2. Pass it safely into the corrected DTO constructor
        PaymentLinkFetchItemDto responseDto = new PaymentLinkFetchItemDto(entity);
        
        // 3. Return response with 200 OK status
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    } catch (IllegalArgumentException e) {
        // Simple manual error handler matching Razorpay documentation structure
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("code", "BAD_REQUEST_ERROR");
        errorDetails.put("description", e.getMessage()); // Will catch "invalid input..." OR "The id provided does not exist"
        errorDetails.put("metadata", new ArrayList<>());
        errorDetails.put("reason", null);
        errorDetails.put("source", null);
        errorDetails.put("step", null);

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", errorDetails);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
   
}




/* 


    // Global Exception Handler local to this controller for the 40 character validation rule
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        Map<String, String> innerError = new HashMap<>();
        
        innerError.put("code", "BAD_REQUEST_ERROR");
        innerError.put("description", ex.getMessage());
        
        errorBody.put("error", innerError);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }



    // --- New Endpoint: Fetch Single Item with Path Variable ---
    @GetMapping("/{id}")
    public ResponseEntity<PaymentLinkFetchItemDto> getPaymentLinkById(@PathVariable("id") String plinkId) {
        
        // 1. Fetch single entity from our validated business layer
        PaymentLink entity = paymentLinkService.getPaymentLinkById(plinkId);
        
        // 2. Map directly into our clean, annotation-free camelCase DTO
        PaymentLinkFetchItemDto responseDto = new PaymentLinkFetchItemDto(PaymentLinkk );
        
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
/* 
    // --- Global Error Handler local to this controller class ---
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String, Object>> handleEndpointExceptions(Exception ex) {
        Map<String, Object> errorRoot = new HashMap<>();
        Map<String, Object> errorDetails = new HashMap<>();
        
        errorDetails.put("code", "BAD_REQUEST_ERROR");
        errorDetails.put("description", ex.getMessage());
        errorDetails.put("metadata", new String[]{});
        errorDetails.put("reason", null);
        errorDetails.put("source", null);
        errorDetails.put("step", null);
        
        errorRoot.put("error", errorDetails);
        return new ResponseEntity<>(errorRoot, HttpStatus.BAD_REQUEST);
    }
*/
