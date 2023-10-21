package com.example.Liabrarys1.Repository;

import com.example.Liabrarys1.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Integer>{
}
