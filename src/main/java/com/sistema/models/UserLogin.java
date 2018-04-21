/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;

/**
 *
 * @author Usuario
 */
public class UserLogin {
   
    private Object user;
    private String token;

    public UserLogin() {
    }

    public void setUser(Object user) {
        this.user = user;
    }

   
    public Object getUser() {
       return this.user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
