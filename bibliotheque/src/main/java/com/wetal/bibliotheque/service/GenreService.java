package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Genre;

import java.util.List;

public interface GenreService {

   List<Genre> allGenres();

   Genre addNew(Genre genre);

   Genre genreById(Long id);

   Genre update(Genre genre, Long id);

   void delete(Long id);
}
