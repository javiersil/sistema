/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

import com.sistema.models.Carrera;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cosma_000
 */
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    public Iterable<Carrera> findByNombre(String nombre);
    public Carrera findOneByNombre(String nombre);
}
