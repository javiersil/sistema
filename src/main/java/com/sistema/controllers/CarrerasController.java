/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;
import com.sistema.models.Carrera;
import com.sistema.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cosma_000
 */
@RestController
@RequestMapping("/carreras")
public class CarrerasController {
     @Autowired
    private CarreraRepository repoCarrera; 
    public CarrerasController() {
    }
    
    @GetMapping
    public Iterable<Carrera> index(@RequestParam(value="nombre", required=false) String nombre){
     if(nombre!=null)
         return this.repoCarrera.findByNombre(nombre);
      return this.repoCarrera.findAll();
    }
    @GetMapping("/{id}")
    public Carrera getOne(@PathVariable Integer id){
       return this.repoCarrera.findOne(id);
    }
    @PostMapping
    public Carrera create(@RequestBody Carrera carrera){
        Carrera tmp = this.repoCarrera.findOneByNombre(carrera.getNombre());
       if(tmp == null){ 
         carrera.setId(0);
         return this.repoCarrera.save(carrera);
       }else return new Carrera();
    }
    @PutMapping
    public Carrera edit(@RequestBody Carrera carrera){
       Carrera tmp = this.repoCarrera.findOne(carrera.getId());
       if(tmp != null){
          tmp.setNombre(carrera.getNombre());
         return this.repoCarrera.save(tmp);
       }else return new Carrera();
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
      try{
          this.repoCarrera.delete(id);
          return true;
      }catch(Exception e){
         return false;
      }
    }
}
