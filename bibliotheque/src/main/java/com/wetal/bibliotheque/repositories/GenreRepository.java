package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre, Long> {

   @Query("SELECT g FROM Genre g WHERE g.id = :id")
   Genre genreById(Long id);

}
