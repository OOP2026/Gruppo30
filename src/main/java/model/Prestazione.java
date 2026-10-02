package model;

import java.time.LocalDate;

public class Prestazione {
    private final String tipo;
    private final LocalDate data;
    private String esito;
    private String stato;
    private String descrizione;
    private final String idwork;
    Ricovero ricoveroassegnato;
    Medico medicoassegnato;
    TurnoLavorativo turno;

    public String getTipo() {
        return tipo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String s){
        stato=s;
    }
    public LocalDate getData(){
        return data;
    }

    public String getIdwork(){
        return idwork;
    }

    public void setEsito(String s){
        esito=s;
    }

    public String getEsito() {
        return esito;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String s){
        descrizione=s;
    }

    public boolean convalidateshift(){
        boolean validturn=false;

        if(this.turno.getData()==this.data)
            validturn=true;
        else
            System.out.println("Turno non valido, assegnare un turno diverso a questa prestazione o cambia la data della prestazione.");

        return validturn;
    }

    public Prestazione(String t, LocalDate d, String s, String de, Ricovero r, Medico m, TurnoLavorativo tl){
        tipo=t;
        data=d;
        idwork=s;
        descrizione=de;
        ricoveroassegnato=r;
        medicoassegnato=m;
        turno=tl;
        esito="Esito Mancante";
        stato="Sconosciuto";
    }
}
