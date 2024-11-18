package org.example.authorbookee.model;


import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    private int id;
    private String title;
    private Author author;
    private double price;
    private int quantity;
    private Date createdAt;

    public Book(String title, Author author, double price, int quantity, Date createdAt) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }
}