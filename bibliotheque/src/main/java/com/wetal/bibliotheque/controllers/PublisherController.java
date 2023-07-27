package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Publisher;
import com.wetal.bibliotheque.service.PublisherService;
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
@RequestMapping("/api/publishers")
public class PublisherController {

   private final PublisherService publisherService;

   public PublisherController(PublisherService publisherService) {
      this.publisherService = publisherService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<Publisher>> all() {
      return ResponseEntity.ok(publisherService.allPublishers());
   }

   @PostMapping("/new")
   public Publisher addNew(@RequestBody Publisher publisher) {
      return publisherService.addNew(publisher);
   }

   @GetMapping("/id")
   public ResponseEntity<Publisher> bookById(@RequestParam("id") Long id) {
      if (id != null) {
         Publisher publisher = publisherService.publisherById(id);
         if (publisher != null) {
            return new ResponseEntity<>(publisher, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Publisher> delete(@PathVariable("id") Long id) {
      Publisher publisher = publisherService.publisherById(id);
      if (publisher != null) {
         publisherService.delete(id);
         return new ResponseEntity<>(publisher, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Publisher> update(@RequestBody Publisher publisher, @PathVariable Long id) {
      Publisher updatedPublisher = publisherService.update(publisher, id);
      if (updatedPublisher != null) {
         return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
