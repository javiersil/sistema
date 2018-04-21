package com.sistema.security;

import com.sistema.models.User;
import com.sistema.models.SessionUserToken;
import com.sistema.repositories.UserRepository;
import com.sistema.repositories.SessionUserTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    private String secret="Sistema";
    @Autowired
    private  SessionUserTokenRepository repo;
    @Autowired
    private UserRepository repoUser;
    
    public String generate(JwtUser jwtUser) {
           
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("group", jwtUser.getGroup());
        claims.put("roles", jwtUser.getRoles());        
        claims.put("key",Math.round(3.24));
        String token=Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)                
                .compact();
        try{
           if(jwtUser.getGroup().equals("ADMINS")){
             User utmp = repoUser.findOne(jwtUser.getId());
             SessionUserToken tmpToken= repo.findByUser(utmp);
             if(tmpToken != null){
               repo.delete(tmpToken.getId());
             }
             SessionUserToken tokenDB = new SessionUserToken();
             tokenDB.setUser(utmp);
             tokenDB.setToken(token);
             tokenDB.setCreate_at(new Date());
             tokenDB.setExpire(300);
             tokenDB.setOrigin(jwtUser.getOrigin());
             repo.save(tokenDB);
            }
        }catch(Exception e){
            return null;
        }
         return token;
    }    
    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            String group =(String) body.get("group");
          
            if(group.equals("ADMINS")){
                SessionUserToken newToken = repo.findByToken(token); 
                if(newToken != null ){
                   if(newToken.getUser().isStatus()){
                   jwtUser = new JwtUser();
                   jwtUser.setName(newToken.getUser().getName());
                   jwtUser.setId(newToken.getUser().getId());
                   jwtUser.setGroup(group);
                   jwtUser.setRoles(newToken.getUser().getRole().getRol());
                }else {
                    repo.delete(newToken);
                   }
                }
                
            }
            
        }
        catch (Exception e) {
           System.out.println(e.getMessage());
        }

        return jwtUser;
    }
}
