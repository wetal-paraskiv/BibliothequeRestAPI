package com.wetal.bibliotheque.service;

import com.wetal.bibliotheque.entities.Register;

import java.util.List;

public interface RegisterService {

   List<Register> filterRegistersByMemberId(Long id);

   List<Register> dueRegisteredCarts();

   List<Register> allRegisters();

   Register registerById(Long id);

   Register addNew(Register register);

   Register returnUpdate(Long id);
}
