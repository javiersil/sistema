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
 * @author cosma_000
 */
@Entity
public class Sangre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;     
    private String tipo;
    private String descripcion;
    private boolean subcripcion;
    
    public Sangre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isSubcripcion() {
        return subcripcion;
    }

    public void setSubcripcion(boolean subcripcion) {
        this.subcripcion = subcripcion;
    }
    
}
