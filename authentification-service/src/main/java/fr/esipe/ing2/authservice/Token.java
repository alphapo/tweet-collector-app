package fr.esipe.ing2.authservice;

import java.io.Serializable;

public class Token implements Serializable {
    private static final long serialVersionUID = -1764970284520387975L;

    String token;

    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
