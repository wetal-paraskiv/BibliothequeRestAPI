package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
   @Query("SELECT a FROM Author a WHERE CONCAT (a.firstName, a.lastName) LIKE CONCAT ('%', :query, '%')")
   List<Author> filterAuthors(String query);

   @Query("SELECT a FROM Author a WHERE a.id = :id")
   Author authorById(Long id);
}
