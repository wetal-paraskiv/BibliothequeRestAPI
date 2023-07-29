package com.wetal.bibliotheque.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "registers")
public class Register {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;

   private String title;

   @ManyToOne()
   @JoinColumn(name = "publisher_id")
   private Publisher publisher;

   @ManyToOne()
   @JoinColumn(name = "genre_id")
   private Genre genre;

   @ManyToOne()
   @JoinColumn(name = "language_id")
   private Language language;

   @CreationTimestamp
   private LocalDateTime created;

   @UpdateTimestamp
   private LocalDateTime updated;

   private boolean available;

   @JsonIdentityInfo(
      scope = Book.class,
      generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "id")
   @ManyToMany(cascade = {
//      CascadeType.PERSIST,
//      CascadeType.MERGE
   })
   @JoinTable(name = "book-author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id")
   )
   private List<Author> authors = new ArrayList<>();

   public void addAuthor(Author author) {
      authors.add(author);
      author.getBooks().add(this);
   }

   public void removeAuthor(Author author) {
      authors.remove(author);
      author.getBooks().remove(this);
   }

   @JsonIdentityInfo(
      scope = Book.class,
      generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "id")
   @ManyToMany(cascade = {
//      CascadeType.PERSIST,
//      CascadeType.MERGE
   })
   @JoinTable(name = "cart-books",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "cart_id")
   )
   private List<Cart> carts = new ArrayList<>();
}

//https://refactorizando.com/en/many-to-many-relationship-hibernate/