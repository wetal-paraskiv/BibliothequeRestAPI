package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Book;

import java.util.List;

public interface BookService {

   List<Book> filterBooks(String query);

   List<Book> allBooks();

   Book addNew(Book book);

   Book bookById(Long id);

   Book update(Book book);

   void delete(Long id);
}
