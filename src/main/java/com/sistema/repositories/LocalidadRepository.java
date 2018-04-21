/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

import com.sistema.models.Estado;
import com.sistema.models.Localidad;
import com.sistema.models.LocalidadPK;
import com.sistema.models.Municipio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author cosma_000
 */
public interface LocalidadRepository  extends CrudRepository<Localidad, LocalidadPK>{
   @Query("SELECT l FROM Localidad as l WHERE l.pk.estado = :e AND l.pk.municipio = :m")
    public Iterable<Localidad> findAllByEstadoMunicipio(@Param("e") Integer e,@Param("m")Integer m);
}
