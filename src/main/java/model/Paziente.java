package model;

import java.time.LocalDate;

public class Paziente {
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    // Non ho trovato necessario implementare l'associazione tra paziente e ricovero, in quanto sarebbe inutile ai fini del programma.

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codice){
        codiceFiscale=codice;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String newn){
        nome=newn;
    }

    public String getCognome(){
        return cognome;
    }
    public void setCognome(String newc){
        cognome=newc;
    }

    public LocalDate getDataNascita(){
        return dataNascita;
    }
    public void setDataNascita(LocalDate newdate){
        dataNascita=newdate;
    }

    public Paziente(String codice, String newn, String newc, LocalDate newdate){
        codiceFiscale=codice;
        nome=newn;
        cognome=newc;
        dataNascita=newdate;
    }
}
