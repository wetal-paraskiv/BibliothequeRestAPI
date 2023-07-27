package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Language;

import java.util.List;

public interface LanguageService {

   List<Language> allLanguages();

   Language addNew(Language language);

   Language langById(Long id);

   Language update(Language language, Long id);

   void delete(Long id);
}
