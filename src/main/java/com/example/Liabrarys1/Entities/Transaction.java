package com.example.Liabrarys1.Entities;

import com.example.Liabrarys1.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId; //Handled by spring automatically


    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Date returnDate;

    private Integer fine;


    @CreationTimestamp
    private Date createdOn; //Handled by Spring internally


    @UpdateTimestamp
    private Date lastModifiedOn; //Handled by Spring internally


    //Connect FK here with Book Entity
    @ManyToOne
    @JoinColumn
    private Book book;


    @ManyToOne
    @JoinColumn
    private LibraryCard card;

}

