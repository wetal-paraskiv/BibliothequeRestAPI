package com.wetal.bibliotheque.service.impl;

import com.wetal.bibliotheque.entities.Book;
import com.wetal.bibliotheque.repositories.BookRepository;
import com.wetal.bibliotheque.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

   private final BookRepository bookRepository;

   @Autowired
   public BookServiceImpl(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   @Override
   public List<Book> filterBooks(String query) {
      return bookRepository.filterBooks(query);
   }

   @Override
   public List<Book> allBooks() {
      return bookRepository.findAll();
   }

   @Override
   public Book addNew(Book book) {
      return bookRepository.save(book);
   }

   @Override
   public Book bookById(Long id) {
      return bookRepository.bookById(id);
   }

   @Override
   public Book update(Book book) {
      bookRepository.save(book);
      return book;
   }

   @Override
   public void delete(Long id) {
      bookRepository.deleteById(id);
   }
}
