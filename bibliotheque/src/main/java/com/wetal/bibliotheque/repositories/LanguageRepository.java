package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LanguageRepository extends JpaRepository<Language, Long> {

   @Query("SELECT l FROM Language l WHERE l.id = :id")
   Language langById(Long id);
}
