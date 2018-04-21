/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

import com.sistema.models.Municipio;
import com.sistema.models.MunicipioPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cosma_000
 */
public interface MunicipioRepository extends CrudRepository<Municipio , MunicipioPK > {
   @Query("SELECT m FROM Municipio as m WHERE m.pk.estado = :e")
    public Iterable<Municipio> findAllByEstado(@Param("e")Integer e);
     //public Municipio findByEstado(,Estado e);
    
}
