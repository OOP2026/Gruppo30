package model;


public class Utente {
    protected String username;
    protected String password;

    
    public boolean login(String usn, String pw){
        return(usn.equals(username)&&pw.equals(password));
    }

    public void logout(){
        //Metodo possibilmente da scartare
    }

    public Utente(String usn, String pw){
        password=pw;
        username=usn;
    }
}


