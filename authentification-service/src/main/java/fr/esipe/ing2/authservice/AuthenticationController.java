package fr.esipe.ing2.authservice;

import fr.esipe.ing2.common.odt.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authApi")
public class AuthenticationController {

    @GetMapping(value = "/{userId}/{password}")
    public ResponseEntity<?> findUser(@PathVariable(value = "userId") String userId,
                                        @PathVariable(value = "password") String password) {
        User user= new User(userId,password);
        return new ResponseEntity<String>(user.toString(), HttpStatus.OK);
    }

}