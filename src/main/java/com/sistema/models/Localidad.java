/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cosma_000
 */
@Entity
public class Localidad {
    
    private String nombre;  
    @EmbeddedId
    private LocalidadPK pk;
    
    public Localidad() {
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalidadPK getPk() {
        return pk;
    }

    public void setPk(LocalidadPK pk) {
        this.pk = pk;
    }

   

      
    
}
