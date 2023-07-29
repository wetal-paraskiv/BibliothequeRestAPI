package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Member;
import com.wetal.bibliotheque.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

   private final MemberService memberService;

   @Autowired
   public MemberController(MemberService memberService) {
      this.memberService = memberService;
   }

   @GetMapping("/filter")
   public ResponseEntity<List<Member>> filterMembers(@RequestParam("query") String query) {
      return ResponseEntity.ok(memberService.filterMembers(query));
   }

   @GetMapping("/all")
   public ResponseEntity<List<Member>> all() {
      return ResponseEntity.ok(memberService.allMembers());
   }

   @PostMapping("/new")
   public Member addNew(@RequestBody Member member) {
      return memberService.addNew(member);
   }

   @GetMapping("/id")
   public ResponseEntity<Member> memberById(@RequestParam("id") Long id) {
      if (id != null) {
         Member member = memberService.memberById(id);
         if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Member> delete(@PathVariable("id") Long id) {
      Member member = memberService.memberById(id);
      if (member != null) {
         memberService.delete(id);
         return new ResponseEntity<>(member, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Member> update(@RequestBody Member member, @PathVariable Long id) {
      Member updatedMember = memberService.update(member, id);
      if (updatedMember != null) {
         return new ResponseEntity<>(updatedMember, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
