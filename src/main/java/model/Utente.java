package model;

public abstract class Utente {
    protected String username;
    protected String password;
    protected boolean loggato = false;

    public Utente(String usn, String pw) {
        this.username = usn;
        this.password = pw;
    }

    public boolean login(String usn, String pw) {
        if (usn.equals(this.username) && pw.equals(this.password)) {
            this.loggato = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.loggato = false;
    }

    public boolean isLoggato() {
        return this.loggato;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}


