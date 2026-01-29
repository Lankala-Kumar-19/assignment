package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactFormResponseDTO {
    private String id;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String city;
}
