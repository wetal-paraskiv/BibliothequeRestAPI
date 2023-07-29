package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Cart;

import java.util.List;

public interface CartService {

   List<Cart> filterCarts(String query);

   List<Cart> allCarts();

   Cart addNew(Cart cart);

   Cart cartById(Long id);

   Cart update(Cart cart, Long id);

   void delete(Long id);
}
