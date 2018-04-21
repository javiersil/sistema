/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;

import com.sistema.models.Sangre;
import org.springframework.web.bind.annotation.RestController;
import com.sistema.repositories.SangreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author cosma_000
 */
@RestController
@RequestMapping("/sangres")
public class SangreController {
    @Autowired
    private SangreRepository repoSangre; 
    public SangreController() {
    }
    @GetMapping
    public Iterable<Sangre> index(){
        return this.repoSangre.findAll();
    }
    @GetMapping("/{id}")
    public Sangre getOne(@PathVariable Integer id){
        return this.repoSangre.findOne(id);
    }
    @PostMapping
    public Sangre create(@RequestBody Sangre sangre){
      Sangre tmp = this.repoSangre.findByTipo(sangre.getTipo());
      if(tmp != null){
          return this.repoSangre.save(sangre);
      }else return null;      
    }
    @PutMapping
    public Sangre edit(@RequestBody Sangre sangre){
       Sangre tmp = this.repoSangre.findOne(sangre.getId());
      if(tmp != null){
          tmp.setTipo(sangre.getTipo());
          return this.repoSangre.save(tmp);
      }else return null;
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
       try{
         this.repoSangre.delete(id);
         return true;
       }catch(Exception e){
           return false;
        }
    }
    
}
