package com.wetal.bibliotheque.service.service_impl;

import com.wetal.bibliotheque.entities.Book;
import com.wetal.bibliotheque.entities.Register;
import com.wetal.bibliotheque.repositories.BookRepository;
import com.wetal.bibliotheque.repositories.RegisterRepository;
import com.wetal.bibliotheque.service.RegisterService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

   private final RegisterRepository registerRepository;
   private final BookRepository bookRepository;

   public RegisterServiceImpl(RegisterRepository registerRepository, BookRepository bookRepository) {
      this.registerRepository = registerRepository;
      this.bookRepository = bookRepository;
   }

   @Override
   public List<Register> filterRegistersByMemberId(Long id) {
      return registerRepository.filterRegistersByMemberId(id);
   }

   @Override
   public List<Register> dueRegisteredCarts() {
      return registerRepository.dueRegisteredCarts();
   }

   @Override
   public List<Register> allRegisters() {
      return registerRepository.findAll();
   }

   @Override
   public Register registerById(Long id) {
      return registerRepository.registerById(id);
   }

   @Override
   public Register addNew(Register register) {
      return registerRepository.save(register);
   }

   @Override
   public Register returnUpdate(Long id) {
      Register registerToUpdate = registerRepository.registerById(id);
      if (registerToUpdate != null) {
         for (Book book: registerToUpdate.getCart().getCartBooks()) {
            book.setAvailable(true);
            bookRepository.save(book);
         }

         LocalDateTime now = LocalDateTime.now();
         registerToUpdate.setReturnDate(now);
         registerToUpdate.setDue(false);
         registerRepository.save(registerToUpdate);
         return registerToUpdate;
      }
      return null;
   }
}
