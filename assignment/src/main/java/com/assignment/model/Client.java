package com.assignment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
public class Client {

    @Id
    private String id;

    private String name;
    private String description;
    private String designation; // e.g., CEO, Designer
    private String imageUrl;
}
