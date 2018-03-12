package fr.esipe.ing2.authservice.controller;

import fr.esipe.ing2.authservice.service.AuthentificationServiceImpl;
import fr.esipe.ing2.common.odt.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authApi")
public class AuthenticationController {

    @Autowired
    private AuthentificationServiceImpl authentificationServiceImpl;

    @GetMapping(value = "/{userId}/{password}")
    public ResponseEntity<?> getToken(@PathVariable(value = "userId") String userId,
                                        @PathVariable(value = "password") String password) {
        User user= new User(userId,password);

        String token = authentificationServiceImpl.generateToken(user);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping(value = "/{token}")
    public ResponseEntity<?> checkToken(@PathVariable(value = "token") String token   ) {

        boolean state = authentificationServiceImpl.validateToken(token);
        return new ResponseEntity<String>(String.valueOf(state), HttpStatus.OK);
    }

}