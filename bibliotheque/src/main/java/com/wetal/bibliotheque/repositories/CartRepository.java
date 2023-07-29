package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
   @Query("SELECT c FROM Cart c WHERE c.member.lastName LIKE CONCAT ('%', :query, '%')")
   List<Cart> filterCarts(String query);

   @Query("SELECT c FROM Cart c WHERE c.id = :id")
   Cart cartById(Long id);
}
