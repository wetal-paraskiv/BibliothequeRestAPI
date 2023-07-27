package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Language;
import com.wetal.bibliotheque.repositories.LanguageRepository;
import com.wetal.bibliotheque.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

   private final LanguageRepository languageRepository;

   @Autowired
   public LanguageServiceImpl(LanguageRepository languageRepository) {
      this.languageRepository = languageRepository;
   }


   @Override
   public List<Language> allLanguages() {
      return languageRepository.findAll();
   }

   @Override
   public Language addNew(Language language) {
      return (Language) languageRepository.save(language);
   }

   @Override
   public Language langById(Long id) {
      return languageRepository.langById(id);
   }

   @Override
   public Language update(Language language, Long id) {
      Language langToUpdate = languageRepository.langById(id);
      if (langToUpdate != null) {
         langToUpdate.setName(language.getName());
         languageRepository.save(langToUpdate);
         return langToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      languageRepository.deleteById(id);
   }
}
