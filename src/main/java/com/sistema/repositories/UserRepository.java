/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

/**
 *
 * @author Usuario
 */
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sistema.models.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

   // @Query("SELECT u, u.password = null FROM  User u WHERE u.name = ?1 AND u.password = ?2 ")
    // public  Page<User>  findByNamePassword(String name, String password, Pageable pageable);
      public  Page<User>  findByName(String name, Pageable pageable); 
      public  User  findByName(String name);
      public User findByNameAndPassword(String name,String Password);
      
}

