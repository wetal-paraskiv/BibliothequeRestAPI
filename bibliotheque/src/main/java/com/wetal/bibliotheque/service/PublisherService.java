package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Publisher;

import java.util.List;

public interface PublisherService {

   List<Publisher> allPublishers();

   Publisher addNew(Publisher publisher);

   Publisher publisherById(Long id);

   Publisher update(Publisher publisher, Long id);

   void delete(Long id);
}
