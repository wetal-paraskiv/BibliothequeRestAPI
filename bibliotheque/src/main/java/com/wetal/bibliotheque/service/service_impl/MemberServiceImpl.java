package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Member;
import com.wetal.bibliotheque.repositories.MemberRepository;
import com.wetal.bibliotheque.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

   private final MemberRepository memberRepository;

   @Autowired
   public MemberServiceImpl(MemberRepository memberRepository) {
      this.memberRepository = memberRepository;
   }

   @Override
   public List<Member> filterMembers(String query) {
      return memberRepository.filterMembers(query);
   }

   @Override
   public List<Member> allMembers() {
      return memberRepository.findAll();
   }

   @Override
   public Member addNew(Member member) {
      return memberRepository.save(member);
   }

   @Override
   public Member memberById(Long id) {
      return memberRepository.memberById(id);
   }

   @Override
   public Member update(Member member, Long id) {
      Member memberToUpdate = memberRepository.memberById(id);
      if (memberToUpdate != null) {
         memberToUpdate.setFirstName(member.getFirstName());
         memberToUpdate.setLastName(member.getLastName());
         memberToUpdate.setEmail(member.getEmail());
         memberToUpdate.setPhone(member.getPhone());
         memberToUpdate.setCarts(member.getCarts());
         memberRepository.save(memberToUpdate);
         return memberToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      memberRepository.deleteById(id);
   }
}
