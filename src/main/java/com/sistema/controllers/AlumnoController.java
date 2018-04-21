/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;

/**
 *
 * @author cosma_000
 */
import com.sistema.models.Alumno;
import com.sistema.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
     @Autowired
     private AlumnoRepository repoAlumno;
     
    public AlumnoController() {
    }
    @GetMapping
    public Page<Alumno> index(@RequestParam(value="page", required=false, defaultValue="0")int page,
                              @RequestParam(value="size", required=false, defaultValue="20")int size ){ 
        
        if(page < 0) page =0;   
        if(size <= 0) size=1;
        if(size > 501) size=500;
         return this.repoAlumno.findAll(new PageRequest(page,size));   
    } 
    @GetMapping("/{id}")
    public Alumno getOne(@PathVariable Long id){
         Alumno tmp = this.repoAlumno.findOne(id);
          if(tmp != null)
          return tmp;
      return new Alumno();    
    }
    @PostMapping
    public Alumno create(@RequestBody Alumno alumno){
        Alumno tmp = this.repoAlumno.findOne(alumno.getId());
      if(tmp == null)
          return this.repoAlumno.save(alumno);
      return null;
    }
    @PutMapping
    public Alumno edit(@RequestBody Alumno alumno){
      Alumno tmp = this.repoAlumno.findOne(alumno.getId());
      if(tmp != null)
          return this.repoAlumno.save(alumno);
      return null;    
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        try{
            this.repoAlumno.delete(id);
            return true;
       }catch(Exception e){
         return false;
       }
       
    }
    
}
