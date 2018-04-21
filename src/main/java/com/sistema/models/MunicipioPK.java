/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author cosma_000
 */
@Embeddable
public class MunicipioPK implements Serializable{
    @Column(name="id")
    private Integer id;
    @Column(name="estadoId")
     private Integer estado;    

    public MunicipioPK() {
    }    
    
    public MunicipioPK(Integer id, Integer estado) {
        this.id = id;
        this.estado = estado;
    }    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    
}
