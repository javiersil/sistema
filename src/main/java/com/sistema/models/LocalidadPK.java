/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cosma_000
 */
@Embeddable
public class LocalidadPK implements Serializable {
    @Column(name="id")
    private Integer id;
    @Column(name="municipioId")
     private Integer municipio; 
    @Column(name="estadoId")
     private Integer estado;

    public LocalidadPK() {
    }

    public LocalidadPK(Integer id, Integer municipio, Integer estado) {
        this.id = id;
        this.municipio = municipio;
        this.estado = estado;
    }    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

   
    
}
