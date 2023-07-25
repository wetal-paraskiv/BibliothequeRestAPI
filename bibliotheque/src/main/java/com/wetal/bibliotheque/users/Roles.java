package com.wetal.bibliotheque.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public enum Roles {
   ADMIN(
      Set.of(
         Permission.ADMIN_POST, Permission.ADMIN_GET, Permission.ADMIN_PUT, Permission.ADMIN_DELETE,
         Permission.MANAGER_POST, Permission.MANAGER_GET, Permission.MANAGER_PUT, Permission.MANAGER_DELETE
      )),
   MANAGER(Set.of(
      Permission.MANAGER_POST, Permission.MANAGER_GET, Permission.MANAGER_PUT
   )),
   USER(Collections.emptySet());

   @Getter
   private final Set<Permission> permissions;

   public List<SimpleGrantedAuthority> simpleGrantedAuthorityList() {
      var permissionAuthorities = getPermissions()
         .stream()
         .map(authority -> new SimpleGrantedAuthority(authority.name()))
         .toList();

      permissionAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

      return permissionAuthorities;
   }
}
