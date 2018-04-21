/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.models;
import java.util.Date;
import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue; 
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author cosma_000
 */
@Entity
public class SessionUserToken {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(length=20)
    private String origin;
    private String token;
     
    private Date create_at;
    private int expire;
    
    @ManyToOne
    private User user;

    public SessionUserToken() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create) {
        this.create_at = create;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
