package fr.esipe.ing2.common.odt;

import java.io.Serializable;

public class User implements Serializable{
     String userId;
     String password;
    public User(String userId, String password){
        this.userId = userId;
        this.password = password;

    }




}
