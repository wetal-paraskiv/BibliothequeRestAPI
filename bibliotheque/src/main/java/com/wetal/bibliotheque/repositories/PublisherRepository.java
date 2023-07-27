package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

   @Query("SELECT p FROM Publisher p WHERE p.id = :id")
   Publisher publisherById(Long id);

}
