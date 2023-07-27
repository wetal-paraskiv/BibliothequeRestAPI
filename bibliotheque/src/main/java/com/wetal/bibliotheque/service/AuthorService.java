package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Author;

import java.util.List;

public interface AuthorService {

   List<Author> filterAuthors(String query);

   List<Author> allAuthors();

   Author addNew(Author author);

   Author authorById(Long id);

   Author update(Author author, Long id);

   void delete(Long id);
}
