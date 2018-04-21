package com.sistema.controllers;

import com.sistema.models.User;
import com.sistema.models.UserLogin;
import com.sistema.repositories.UserRepository;
import com.sistema.security.JwtGenerator;
import com.sistema.security.JwtUser;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
     @Autowired
     private UserRepository repo;
   
    private JwtGenerator jwtGenerator;

    public LoginController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public UserLogin generate(@RequestBody final User user,HttpServletRequest request) {
         UserLogin userLogin=  new UserLogin();
        try{
           User u;
           u= repo.findByNameAndPassword(user.getName(),user.getPassword());
           
            if(u != null){ 
                userLogin.setUser(u);
                
                JwtUser jwtUser = new JwtUser(u.getId(),u.getName(),"ADMINS",u.getRole().getRol());
                jwtUser.setOrigin(request.getRemoteAddr());
                userLogin.setToken(jwtGenerator.generate(jwtUser));
               }
          
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
        
        return userLogin;

    }
}
