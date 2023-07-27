package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Author;
import com.wetal.bibliotheque.service.AuthorService;
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
@RequestMapping("/api/authors")
public class AuthorController {

   private final AuthorService authorService;

   @Autowired
   public AuthorController(AuthorService authorService) {
      this.authorService = authorService;
   }


   @GetMapping("/filter")
   public ResponseEntity<List<Author>> filterAuthors(@RequestParam("query") String query) {
      return ResponseEntity.ok(authorService.filterAuthors(query));
   }

   @GetMapping("/all")
   public ResponseEntity<List<Author>> all() {
      return ResponseEntity.ok(authorService.allAuthors());
   }

   @PostMapping("/new")
   public Author addNew(@RequestBody Author author) {
      return authorService.addNew(author);
   }

   @GetMapping("/id")
   public ResponseEntity<Author> authorById(@RequestParam("id") Long id) {
      if (id != null) {
         Author author = authorService.authorById(id);
         if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Author> delete(@PathVariable("id") Long id) {
      Author author = authorService.authorById(id);
      if (author != null) {
         authorService.delete(id);
         return new ResponseEntity<>(author, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Author> update(@RequestBody Author author, @PathVariable Long id) {
      Author updatedAuthor = authorService.update(author, id);
      if (updatedAuthor != null) {
         return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
