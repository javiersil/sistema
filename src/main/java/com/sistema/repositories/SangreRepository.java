/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

import com.sistema.models.Sangre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cosma_000
 */
public interface SangreRepository extends CrudRepository<Sangre,Integer>{
    public Sangre findByTipo(String tipo);    
}
