package com.mycompany.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
}
