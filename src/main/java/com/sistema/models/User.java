/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue; 
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "Users")
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private long  id; 
   @Column(length=40)
    private String name;
    @JsonIgnore
    @Column(length=70)
    private String password;
    
    private boolean status;

    @ManyToOne
    private Role role;
    
    public User() {
    }

    public long  getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @JsonIgnore 
    public String getPassword() {
        return password;
    }
     @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
     public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
