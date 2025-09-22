package com.Bajaj.ApiChallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api")
public class SubmissionController {

    @PutMapping("/submit")
    public ResponseEntity<?> submitSolution(
            @RequestHeader("Name") String name,
            @RequestHeader("Email") String email,
            @RequestHeader("College") String college,
            @RequestHeader("StudentId") String studentId,
            @RequestHeader("FileName") String fileName,
            @RequestHeader("Password") String password,
            @RequestBody byte[] fileBytes
    ) throws IOException {

        // (Optional) Save the received file for verification
        Path outputPath = Path.of("uploads", fileName);
        Files.createDirectories(outputPath.getParent());
        Files.write(outputPath, fileBytes);

        // Build response
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new SubmissionResponse(200,
                                "Your details have been submitted successfully")
                );
    }

    // DTO for JSON response
    static class SubmissionResponse {
        private int status;
        private String message;

        public SubmissionResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() { return status; }
        public String getMessage() { return message; }
    }
}

