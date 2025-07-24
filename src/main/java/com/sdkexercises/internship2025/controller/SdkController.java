package com.sdkexercises.internship2025.controller;

import com.sdkexercises.internship2025.handlers.Handler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sdk")
public class SdkController {

    private final Handler handler;

    public SdkController(Handler handler) {
        this.handler = handler;
    }

    /**
     * Sends a test AWS S3 request:
     * - Creates a new bucket
     * - Uploads an object
     * - Deletes the object and the bucket
     */
    @PostMapping("/test")
    public ResponseEntity<String> sendSdkRequest() {
        try {
            handler.sendRequest();
            return ResponseEntity.ok("S3 request executed successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("S3 request failed: " + e.getMessage());
        }
    }

    @PostMapping("/invoke-lambda")
    public ResponseEntity<String> invokeLambda(
            @RequestParam String functionName,
            @RequestBody String payload) {
        try {
            String response = handler.invokeLambda(functionName, payload);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error invoking Lambda: " + e.getMessage());
        }
    }
}
