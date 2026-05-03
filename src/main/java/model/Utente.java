package model;

import java.util.ArrayList;

public class Utente {
    protected String username;
    protected String password;


    public boolean login(String usn, String pw){
        return(usn==username&&pw==password);
    }

    public void logout(){}

    public Utente(String usn, String pw){
        password=pw;
        username=usn;
    }
}


