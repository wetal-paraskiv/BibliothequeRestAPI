package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
   @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT ('%', :query, '%')")
   List<Book> filterBooks(String query);

   @Query("SELECT b FROM Book b WHERE b.id = :id")
   Book bookById(Long id);
}
