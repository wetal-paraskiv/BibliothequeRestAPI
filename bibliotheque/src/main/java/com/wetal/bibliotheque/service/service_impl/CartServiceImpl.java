package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Book;
import com.wetal.bibliotheque.entities.Cart;
import com.wetal.bibliotheque.entities.Register;
import com.wetal.bibliotheque.repositories.BookRepository;
import com.wetal.bibliotheque.repositories.CartRepository;
import com.wetal.bibliotheque.repositories.RegisterRepository;
import com.wetal.bibliotheque.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

   private final CartRepository cartRepository;
   private final BookRepository bookRepository;
   private final RegisterRepository registerRepository;

   @Autowired
   public CartServiceImpl(CartRepository cartRepository, BookRepository bookRepository, RegisterRepository registerRepository) {
      this.cartRepository = cartRepository;
      this.bookRepository = bookRepository;
      this.registerRepository = registerRepository;
   }

   @Override
   public List<Cart> filterCarts(String query) {
      return cartRepository.filterCarts(query);
   }

   @Override
   public List<Cart> allCarts() {
      return cartRepository.findAll();
   }

   @Override
   public Cart addNew(Cart cart) {
      for (Book b: cart.getCartBooks()) {
         Book book = bookRepository.bookById(b.getId());
         book.setAvailable(false);
         bookRepository.save(book);
      }
      cartRepository.save(cart);
      Register register = new Register();
      register.setCart(cart);
      register.setDue(true);
      registerRepository.save(register);
      return cart;
   }

   @Override
   public Cart cartById(Long id) {
      return cartRepository.cartById(id);
   }

   @Override
   public Cart update(Cart cart, Long id) {
      Cart cartToUpdate = cartRepository.cartById(id);
      if (cartToUpdate != null) {
         cartToUpdate.setMember(cart.getMember());
         cartToUpdate.setCartBooks(cart.getCartBooks());
         cartRepository.save(cartToUpdate);
         return cartToUpdate;
      }
      return null;
   }

   @Override
   public void delete(Long id) {
      cartRepository.deleteById(id);
   }
}
