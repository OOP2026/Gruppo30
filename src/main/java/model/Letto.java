package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Letto {
    private final String code;
    Stanza s;
    ArrayList<Ricovero> ricoveriAssegnati;

    public Letto(String c, Stanza s){
        code=c;
        this.s=s;
    }

    public String getCode() {
        return code;
    }

    public boolean isAvailable(LocalDate d1, LocalDate d2){
        boolean availability=false;
        for(Ricovero ricovero : ricoveriAssegnati){
            if(d1.isBefore(ricovero.getStart()) && d2.isBefore(ricovero.getStart()))
                availability=true;
            else if(d1.isAfter(ricovero.getEnd()) && d2.isAfter(ricovero.getEnd()))
                availability=true;
        }
        return availability;
    }

    public void getSituation(LocalDate date){
        //Questo metodo necessita la GUI per l'implementazione, quindi rimane un prototipo per ora.
    }

    public List<Ricovero> getRicoveriAssegnati(){
        return ricoveriAssegnati;
    }
}
