/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author cosma_000
 */
@Entity
public class Alumno {
  @Id  
  private long id;  
  @Column(length=10,unique=true)
  private String  numeroControl;
  
  @Column(length=10)
  private String nip;
  @Column(length=60)
  private String nombres;
  @Column(length=40)
  private String apellidoPaterno;
  @Column(length=40)
  private String apellidoMaterno;
  @Column(length=18)
  private String curp;
  @ManyToOne
  private Sangre sangre;
  @ManyToOne
  private Carrera carrera;  
  private int numeroCasa;
  @Column(length=100)
  private String calle;
  private Integer localidad;
  private Integer municipio;
  private Integer estado;  
  private int codigoPostal;
  private long numeroEmergencia;
  private long numeroPersonal;
  @Column(length=150)
  private String urlFoto;
  @Column(length=150)
  private String urlFirma;
  
  private boolean status;
  private Date creado;
  private Date editado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Sangre getSangre() {
        return sangre;
    }

    public void setSangre(Sangre sangre) {
        this.sangre = sangre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public long getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(long numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public long getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(long numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlFirma() {
        return urlFirma;
    }

    public void setUrlFirma(String urlFirma) {
        this.urlFirma = urlFirma;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }
  
  
  
}
