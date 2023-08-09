package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Long> {
   @Query("SELECT r FROM Register r WHERE r.cart.member.id = :id")
   List<Register> filterRegistersByMemberId(Long id);

   @Query("SELECT r FROM Register r WHERE r.due = TRUE")
   List<Register> dueRegisteredCarts();

   @Query("SELECT r FROM Register r WHERE r.id = :id")
   Register registerById(Long id);

}
