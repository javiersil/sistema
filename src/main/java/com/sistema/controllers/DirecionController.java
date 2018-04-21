/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.controllers;

import com.sistema.models.Estado;
import com.sistema.models.Localidad;
import com.sistema.models.LocalidadPK;
import com.sistema.models.Municipio;
import com.sistema.repositories.EstadoRepository;
import com.sistema.repositories.LocalidadRepository;
import com.sistema.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cosma_000
 */
@RestController
public class DirecionController {
    @Autowired
    private EstadoRepository repoEstado;    
    @Autowired
    private MunicipioRepository repoMunicipio;    
    @Autowired
    private LocalidadRepository repoLocalidad;
    
    @GetMapping("/estados")
    public Iterable<Estado> getEstados(){
       return repoEstado.findAll();
    }
    
    @GetMapping("/estados/{ide}/municipios")
    public Iterable<Municipio> getMunicipios(@PathVariable Integer ide){        
         return this.repoMunicipio.findAllByEstado(ide);        
    }
    
    @GetMapping("/estados/{ide}/municipios/{idm}/localidades")
    public Iterable<Localidad> getLocalidades(@PathVariable Integer ide,@PathVariable Integer idm){        
           return this.repoLocalidad.findAllByEstadoMunicipio(ide, idm);
    }
    
    @GetMapping("/estados/{ide}/municipios/{idm}/localidades/{idl}")
    public Localidad getLocalidade(@PathVariable Integer ide,@PathVariable Integer idm,@PathVariable Integer idl){     
           LocalidadPK lpk = new LocalidadPK();
           lpk.setEstado(ide);
           lpk.setMunicipio(idm);
           lpk.setId(idl);
           return this.repoLocalidad.findOne(lpk);
    }
}
