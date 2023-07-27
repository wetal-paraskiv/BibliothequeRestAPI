package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Publisher;
import com.wetal.bibliotheque.repositories.PublisherRepository;
import com.wetal.bibliotheque.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

   private final PublisherRepository publisherRepository;

   @Autowired
   public PublisherServiceImpl(PublisherRepository publisherRepository) {
      this.publisherRepository = publisherRepository;
   }

   @Override
   public List<Publisher> allPublishers() {
      return publisherRepository.findAll();
   }

   @Override
   public Publisher addNew(Publisher publisher) {
      return publisherRepository.save(publisher);
   }

   @Override
   public Publisher publisherById(Long id) {
      return publisherRepository.publisherById(id);
   }

   @Override
   public Publisher update(Publisher publisher, Long id) {
      Publisher publisherToUpdate = publisherRepository.publisherById(id);
      if (publisherToUpdate != null) {
         publisherToUpdate.setName(publisher.getName());
         publisherRepository.save(publisherToUpdate);
         return publisherToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      publisherRepository.deleteById(id);
   }
}
