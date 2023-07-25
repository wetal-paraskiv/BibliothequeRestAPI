package com.wetal.bibliotheque.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

   @GetMapping("/home")
   public String homePage(){
      return "Bibiotheque application: HOME page!";
   }

   @GetMapping("/admin")
   public String admin(){
      return "Bibiotheque application: Hello ADMIN...";
   }

   @GetMapping("/users")
   public String user(){
      return "Bibiotheque application: Hello unknown user...";
   }
}
