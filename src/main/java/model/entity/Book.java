package model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "image_link")
    private String imageLink;
    @Column(name = "price")
    private float price;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "quantity_left")
    private int quantityLeft;
    @Column(name = "status")
    private String status;
    @Column(name = "title")
    private String title;
}
