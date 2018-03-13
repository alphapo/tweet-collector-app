package fr.esipe.ing2.authservice.controller;

import fr.esipe.ing2.authservice.Token;
import fr.esipe.ing2.authservice.service.AuthentificationServiceImpl;
import fr.esipe.ing2.common.odt.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authApi")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthentificationServiceImpl authentificationServiceImpl;

    @GetMapping(value = "/{userId}/{password}")
    @ResponseBody
    public ResponseEntity<Token> getToken(@PathVariable(value = "userId") String userId,
                                        @PathVariable(value = "password") String password) {
        User user= new User(userId,password);

        String generateTokentoken = authentificationServiceImpl.generateToken(user);
        Token token = new Token();
        token.setToken(generateTokentoken);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping(value = "/{token}")
    public ResponseEntity<?> checkToken(@PathVariable(value = "token") String token   ) {

        boolean state = authentificationServiceImpl.validateToken(token);
        return new ResponseEntity<>(String.valueOf(state), HttpStatus.OK);
    }

}