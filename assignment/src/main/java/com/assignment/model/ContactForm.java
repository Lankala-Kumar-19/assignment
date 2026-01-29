package com.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contact_forms")
@Data
public class ContactForm {

    @Id
    private String id;

    private String fullName;
    private String email;
    private String mobileNumber;
    private String city;
}
