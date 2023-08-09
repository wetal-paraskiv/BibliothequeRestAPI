package com.wetal.bibliotheque.controllers;

import com.wetal.bibliotheque.entities.Register;
import com.wetal.bibliotheque.service.RegisterService;
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
@RequestMapping("/api/registers")
public class RegisterController {

   private final RegisterService registerService;

   @Autowired
   public RegisterController(RegisterService registerService) {
      this.registerService = registerService;
   }


   @GetMapping("/filter")
   public ResponseEntity<List<Register>> filterRegistersByMemberId(@RequestParam("query") Long id) {
      return ResponseEntity.ok(registerService.filterRegistersByMemberId(id));
   }

   @GetMapping("/due")
   public List<Register> dueRegisteredCarts() {
      return registerService.dueRegisteredCarts();
   }

   @GetMapping("/all")
   public ResponseEntity<List<Register>> all() {
      return ResponseEntity.ok(registerService.allRegisters());
   }

   @GetMapping("/id")
   public ResponseEntity<Register> registerById(@RequestParam("id") Long id) {
      if (id != null) {
         Register register = registerService.registerById(id);
         if (register != null) {
            return new ResponseEntity<>(register, HttpStatus.OK);
         }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
   }

   @PostMapping("/return-update/{id}")
   public ResponseEntity<Register> update(@PathVariable Long id) {
      Register updatedRegister = registerService.returnUpdate(id);
      if (updatedRegister != null) {
         return new ResponseEntity<>(updatedRegister, HttpStatus.OK);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
   }

}
