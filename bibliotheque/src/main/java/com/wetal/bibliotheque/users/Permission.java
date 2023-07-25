package com.wetal.bibliotheque.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@RequiredArgsConstructor
public enum Permission {

   ADMIN_GET("admin:get"),
   ADMIN_POST("admin:post"),
   ADMIN_PUT("admin:put"),
   ADMIN_DELETE("admin:delete"),

   MANAGER_GET("manager:get"),
   MANAGER_POST("manager:post"),
   MANAGER_PUT("manager:put"),
   MANAGER_DELETE("manager:delete");

   @Getter
   private final String permissions;

}
