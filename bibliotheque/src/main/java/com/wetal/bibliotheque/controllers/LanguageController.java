package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Language;
import com.wetal.bibliotheque.service.LanguageService;
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
@RequestMapping("/api/languages")
public class LanguageController {

   private final LanguageService languageService;

   public LanguageController(LanguageService languageService) {
      this.languageService = languageService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<Language>> all() {
      return ResponseEntity.ok(languageService.allLanguages());
   }

   @PostMapping("/new")
   public Language addNew(@RequestBody Language language) {
      return languageService.addNew(language);
   }

   @GetMapping("/id")
   public ResponseEntity<Language> langById(@RequestParam("id") Long id) {
      if (id != null) {
         Language language = languageService.langById(id);
         if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Language> delete(@PathVariable("id") Long id) {
      Language language = languageService.langById(id);
      if (language != null) {
         languageService.delete(id);
         return new ResponseEntity<>(language, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Language> update(@RequestBody Language language, @PathVariable Long id) {
      Language updatedLanguage = languageService.update(language, id);
      if (updatedLanguage != null) {
         return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
