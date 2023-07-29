package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Cart;
import com.wetal.bibliotheque.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

   private final CartService cartService;

   @Autowired
   public CartController(CartService cartService) {
      this.cartService = cartService;
   }

   @GetMapping("/filter")
   public ResponseEntity<List<Cart>> filterCarts(@RequestParam("query") String query) {
      return ResponseEntity.ok(cartService.filterCarts(query));
   }

   @GetMapping("/all")
   public ResponseEntity<List<Cart>> all() {
      return ResponseEntity.ok(cartService.allCarts());
   }

   @PostMapping("/new")
   public Cart addNew(@RequestBody Cart cart) {
      return cartService.addNew(cart);
   }

   @GetMapping("/id")
   public ResponseEntity<Cart> cartById(@RequestParam("id") Long id) {
      if (id != null) {
         Cart cart = cartService.cartById(id);
         if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Cart> delete(@PathVariable("id") Long id) {
      Cart cart = cartService.cartById(id);
      if (cart != null) {
         cartService.delete(id);
         return new ResponseEntity<>(cart, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/update/{id}")
   public ResponseEntity<Cart> update(@RequestBody Cart cart, @PathVariable Long id) {
      Cart updatedCart = cartService.update(cart, id);
      if (updatedCart != null) {
         return new ResponseEntity<>(updatedCart, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
