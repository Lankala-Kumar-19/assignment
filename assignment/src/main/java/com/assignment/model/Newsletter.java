package com.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "newsletter_subscriptions")
@Data
public class Newsletter {

    @Id
    private String id;

    private String email;
}
