/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;

import com.sistema.models.Role;
import org.springframework.web.bind.annotation.*;
import com.sistema.repositories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/rolesuser")
public class RolesController {
    @Autowired
    private RoleRepository repoRol;
    
    @GetMapping
    public Iterable<Role> index(){   
       return this.repoRol.findAll();
       //return repo.findAll(new PageRequest(0,20));      
    }
}
