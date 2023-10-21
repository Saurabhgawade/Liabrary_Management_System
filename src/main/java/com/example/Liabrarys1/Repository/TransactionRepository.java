package com.example.Liabrarys1.Repository;

import com.example.Liabrarys1.Entities.Book;
import com.example.Liabrarys1.Entities.LibraryCard;
import com.example.Liabrarys1.Entities.Transaction;
import com.example.Liabrarys1.Enum.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Transaction findTransactionByBookAndCardAndTransactionStatus(Book book, LibraryCard card, TransactionStatus transactionStatus);
}
