package model;

import java.time.LocalDate;

public class Prestazione {
    private String tipo;
    private LocalDate data;
    private String esito=null;
    private String stato;
    private String descrizione;
    private String idwork;
    Ricovero ricoveroassegnato;
    Medico medicoassegnato;
    TurnoLavorativo turno;


    public LocalDate getData(){
        return data;
    }

    public String getIdwork(){
        return idwork;
    }

    public void setEsito(String s){
        esito=s;
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
        stato=s;
        descrizione=de;
        ricoveroassegnato=r;
        medicoassegnato=m;
        turno=tl;
    }
}
