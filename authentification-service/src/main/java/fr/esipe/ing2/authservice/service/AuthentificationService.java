package fr.esipe.ing2.authservice.service;

import fr.esipe.ing2.common.odt.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;


/**
 * Created by barry on 11/03/2018.
 */

@Service
public class AuthentificationService implements AuthentificationServiceImpl {

    static String token;

    @Override
    public String generateToken(User user) {
        Base64 base64 = new Base64();
        token = new String(base64.encode(user.toString().getBytes()));
        return token;
    }

    @Override
    public boolean validateToken(String tokenToValidate) {
        Base64 base64 = new Base64();
        return (token.equals(tokenToValidate));
    }
}
