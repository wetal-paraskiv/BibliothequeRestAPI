package com.wetal.bibliotheque.repositories;

import com.wetal.bibliotheque.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
   @Query("SELECT m FROM Member m WHERE CONCAT (m.firstName, m.lastName) LIKE CONCAT ('%', :query, '%')")
   List<Member> filterMembers(String query);

   @Query("SELECT m FROM Member m WHERE m.id = :id")
   Member memberById(Long id);
}
