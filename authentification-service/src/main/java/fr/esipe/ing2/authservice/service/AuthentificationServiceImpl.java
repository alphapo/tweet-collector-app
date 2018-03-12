package fr.esipe.ing2.authservice.service;

import fr.esipe.ing2.common.odt.User;

/**
 * Created by barry on 11/03/2018.
 */
public interface AuthentificationServiceImpl {
    String generateToken(User user);
    boolean validateToken(String token);
}
