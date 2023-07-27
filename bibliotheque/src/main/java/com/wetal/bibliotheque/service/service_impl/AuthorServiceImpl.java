package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Author;
import com.wetal.bibliotheque.repositories.AuthorRepository;
import com.wetal.bibliotheque.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

   private final AuthorRepository authorRepository;

   @Autowired
   public AuthorServiceImpl(AuthorRepository authorRepository) {
      this.authorRepository = authorRepository;
   }


   @Override
   public List<Author> filterAuthors(String query) {
      return authorRepository.filterAuthors(query);
   }

   @Override
   public List<Author> allAuthors() {
      return authorRepository.findAll();
   }

   @Override
   public Author addNew(Author author) {
      return authorRepository.save(author);
   }

   @Override
   public Author authorById(Long id) {
      return authorRepository.authorById(id);
   }

   @Override
   public Author update(Author author, Long id) {
      Author authorToUpdate = authorRepository.authorById(id);
      if (authorToUpdate != null) {
         authorToUpdate.setFirstName(author.getFirstName());
         authorToUpdate.setLastName(author.getLastName());
         authorToUpdate.setBooks(author.getBooks());
         authorRepository.save(authorToUpdate);
         return authorToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      authorRepository.deleteById(id);
   }
}
