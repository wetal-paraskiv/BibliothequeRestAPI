package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Member;

import java.util.List;

public interface MemberService {

   List<Member> filterMembers(String query);

   List<Member> allMembers();

   Member addNew(Member member);

   Member memberById(Long id);

   Member update(Member member, Long id);

   void delete(Long id);
}
