package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Genre;
import com.wetal.bibliotheque.repositories.GenreRepository;
import com.wetal.bibliotheque.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

   private final GenreRepository genreRepository;

   @Autowired
   public GenreServiceImpl(GenreRepository genreRepository) {
      this.genreRepository = genreRepository;
   }

   @Override
   public List<Genre> allGenres() {
      return genreRepository.findAll();
   }

   @Override
   public Genre addNew(Genre genre) {
      return genreRepository.save(genre);
   }

   @Override
   public Genre genreById(Long id) {
      return genreRepository.genreById(id);
   }

   @Override
   public Genre update(Genre genre, Long id) {
      Genre genreToUpdate = genreRepository.genreById(id);
      if (genreToUpdate != null) {
         genreToUpdate.setName(genre.getName());
         genreToUpdate.setDescription(genre.getDescription());
         genreRepository.save(genreToUpdate);
         return genreToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      genreRepository.deleteById(id);
   }
}
