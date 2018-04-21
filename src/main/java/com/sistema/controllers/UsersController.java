/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;

import com.sistema.models.Role;
import com.sistema.models.User;
import com.sistema.repositories.RoleRepository;
import org.springframework.web.bind.annotation.*;
import com.sistema.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/users")
public class UsersController {
     @Autowired
    private UserRepository repoUser;
      @Autowired
      private RoleRepository repoRole;
    
    @GetMapping
    public Page<User> index(@RequestParam(value="name", required=false) String name,
                            @RequestParam(value="page", required=false, defaultValue="0")int page,
                            @RequestParam(value="size", required=false, defaultValue="20")int size ){ 
        
        if(page < 0) page =0;   
        if(size <= 0) size=1;
        if(size > 501) size=500;
        if(name != null){
        return this.repoUser.findByName(name,new PageRequest(page,size));
        }
       return this.repoUser.findAll(new PageRequest(page,size));      
    }
    
    @GetMapping("/{id}")
    public User getOne(@PathVariable long id){        
       return this.repoUser.findOne(id);       
    }
    @PostMapping
    public User create(@RequestBody User user){        
        User tmp = this.repoUser.findOne(user.getId());
        if (tmp == null){
        tmp = this.repoUser.findByName(user.getName());
        if(tmp == null){
            if(user.getRole() != null){
             Role rol = this.repoRole.findOne(user.getRole().getId());
             if(rol == null)
                 user.setRole(new Role(2,"SERVICIO"));
            }
            user.setId(0);
            return this.repoUser.save(user);
        }
        }
        return new User();
    }
    @PutMapping
    public User edit(@RequestBody User user){   
       User tmp = this.repoUser.findOne(user.getId());              
        if (tmp != null) {            
            tmp.setStatus(user.isStatus());
            
            if(user.getName() != null){
            tmp.setName(user.getName());
            }
            
            if(user.getPassword() != null){
            tmp.setPassword(user.getPassword());
            }
            
            if(user.getRole() != null){  
             Role r = this.repoRole.findOne(user.getRole().getId());   
            tmp.setRole(r);
            }else
            {
               Role r = this.repoRole.findOne(2L);   
            tmp.setRole(r);
            }
            
            return this.repoUser.save(tmp);
        }
        return new User();
        
     }
     @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){        
         try{
            if(this.repoUser.findOne(id) != null){
            this.repoUser.delete(id);        
            }     
            return true; 
        }catch(Exception e){            
            return false;                        
        }   
    }
}
