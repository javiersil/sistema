/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.repositories;

import com.sistema.models.SessionUserToken;
import com.sistema.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cosma_000
 */
public interface SessionUserTokenRepository extends CrudRepository<SessionUserToken, Long> {
     public SessionUserToken findByToken(String token);
     public SessionUserToken findByUser(User u);
}
