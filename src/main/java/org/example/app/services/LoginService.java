/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

/**
 *
 * @author mak
 * 
 */

@Service

public class LoginService {
    
    private Logger logger = Logger.getLogger(LoginService.class);

    public boolean authenticate(LoginForm loginform) {
        logger.info("try to auth: "+loginform.toString());
        return  loginform.getUsername().equals("root") && loginform.getPassword().equals("123");
    }
    
}
