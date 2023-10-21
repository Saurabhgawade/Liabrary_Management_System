package com.example.Liabrarys1.Repository;

import com.example.Liabrarys1.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
