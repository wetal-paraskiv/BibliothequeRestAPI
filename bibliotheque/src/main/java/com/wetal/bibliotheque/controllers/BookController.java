package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Book;
import com.wetal.bibliotheque.service.BookService;
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

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

   // constructor based dependency injection (not using @Autowired because class has only one constructor & spring knows...)
   private final BookService bookService;

   public BookController(BookService bookService) {
      this.bookService = bookService;
   }

   @GetMapping("/filter")
   public ResponseEntity<List<Book>> filterBooks(@RequestParam("query") String query) {
      return ResponseEntity.ok(bookService.filterBooks(query));
   }

   @GetMapping("/all")
   public ResponseEntity<List<Book>> all() {
      return ResponseEntity.ok(bookService.allBooks());
   }

   @PostMapping("/new")
   public Book addNew(@RequestBody Book book) {
      return bookService.addNew(book);
   }

   @GetMapping("/id")
   public ResponseEntity<Book> bookById(@RequestParam("id") Long id) {
      if (id != null) {
         Book book = bookService.bookById(id);
         if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Book> delete(@PathVariable("id") Long id) {
      Book book = bookService.bookById(id);
      if (book != null) {
         bookService.delete(id);
         return new ResponseEntity<>(book, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Long id) {
      Book bookToUpdate = bookService.bookById(id);
      if (bookToUpdate != null) {
         bookToUpdate.setAuthor_id(book.getAuthor_id());
         bookToUpdate.setGenre_id(book.getGenre_id());
         bookToUpdate.setTitle(book.getTitle());
         bookToUpdate.setLanguage_id(book.getLanguage_id());
         bookToUpdate.setPublisher_id(book.getPublisher_id());
         LocalDateTime now = LocalDateTime.now();
         bookToUpdate.setUpdated(now);
         bookService.update(bookToUpdate);
         return new ResponseEntity<>(bookToUpdate, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
