package com.example.java.model;

import com.example.java.Enum.BookType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(length = 20, unique= true)
    private String books;

    @Enumerated
    private BookType bookType;

    @Column(nullable = false)
    private Double securityAmount;

    private Date createdOn;
    private Date updatedOn;

//    @JoinColumn(name = "any field from user")
//    by default the id is picked for joining
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Transaction> TransactionList;

}
