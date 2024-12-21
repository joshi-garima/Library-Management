package com.example.java.model;



import com.example.java.Enum.UserStatus;
import com.example.java.Enum.UserType;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(nullable = true, unique = true, length = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    private String address;

    private Date createdOn;
    private Date updatedOn;

    @Enumerated
    private UserStatus userStatus;

//    (Value = Enum.String) --> if we want the values to string instead of ordinal
    @Enumerated
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<Book> bookList;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionsList;

}
