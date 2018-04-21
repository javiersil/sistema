/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue; 
 import javax.persistence.GenerationType;
 import javax.persistence.Id;


/**
 *
 * @author Usuario
 */
@Entity
public class Role {
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
    private long  id;   
    private String name;

    public Role() {
    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public String getRol() {
        return name;
    }

    public void setRol(String rol) {
        this.name = rol;
    }
    
  
}
