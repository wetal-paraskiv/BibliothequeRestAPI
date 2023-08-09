package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Genre;
import com.wetal.bibliotheque.service.GenreService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/api/genres")
public class GenreController {

   private final GenreService genreService;

   @Autowired
   public GenreController(GenreService genreService) {
      this.genreService = genreService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<Genre>> all() {
      return ResponseEntity.ok(genreService.allGenres());
   }

   @PostMapping("/new")
   public Genre addNew(@RequestBody Genre genre) {
      return genreService.addNew(genre);
   }

   @GetMapping("/id")
   public ResponseEntity<Genre> genreById(@RequestParam("id") Long id) {
      if (id != null) {
         Genre genre = genreService.genreById(id);
         if (genre != null) {
            return new ResponseEntity<>(genre, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Genre> delete(@PathVariable("id") Long id) {
      Genre genre = genreService.genreById(id);
      if (genre != null) {
         genreService.delete(id);
         return new ResponseEntity<>(genre, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Genre> update(@RequestBody Genre genre, @PathVariable Long id) {
      Genre updatedGenre = genreService.update(genre, id);
      if (updatedGenre != null) {
         return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
