package model;


public class Utente {
    protected String username;
    protected String password;
    protected boolean loggato = false;

    
    public boolean login(String usn, String pw){
        return(usn.equals(username)&&pw.equals(password));
    }
    public void logout(){
        this.loggato = false;
    }
    public boolean isLoggato(){
        return this.loggato;
    }
    public void login(){
        // da aggiornare
    }
    public Utente(String usn, String pw){
        password=pw;
        username=usn;
    }
    public String ritornaUser(){
        return this.username;
    }
}


