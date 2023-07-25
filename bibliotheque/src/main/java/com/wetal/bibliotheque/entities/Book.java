package com.wetal.bibliotheque.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;

   private String title;
   private String author_id;
   private String publisher_id;
   private String genre_id;
   private String language_id;
//   @ManyToOne
//   @JoinColumn(name = "author_id")
//   private Author author;

//   @ManyToOne
//   @JoinColumn(name = "publisher_id")
//   private Publisher publisher;
//
//   @ManyToOne
//   @JoinColumn(name = "genre_id")
//   private Genre genre;
//
//   @ManyToOne
//   @JoinColumn(name = "language_id")
//   private Language language;

   @CreationTimestamp
   private LocalDateTime created;

   @UpdateTimestamp
   private LocalDateTime updated;

   private boolean available;

//   @ManyToMany(mappedBy = "cart_books")
//   private Set<Cart> cartSet;
}
