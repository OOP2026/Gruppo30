package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Letto {
    private String code;
    Stanza s;
    ArrayList<Ricovero> ricoveriAssegnati;

    public Letto(String c, Stanza s){
        code=c;
        this.s=s;
    }



    public boolean isAvailable(LocalDate d1, LocalDate d2){
        boolean availability=true;
        for(int i=0; i<ricoveriAssegnati.size();i++){
            if(d1.isBefore(ricoveriAssegnati.get(i).getStart()) && d2.isBefore(ricoveriAssegnati.get(i).getStart())) {
                if (d1.isAfter(ricoveriAssegnati.get(i).getEnd()) && d2.isAfter(ricoveriAssegnati.get(i).getEnd())){
                    //Codice vuoto in quanto non necessario eseguire operazioni in caso la condizione e' vera.
                }
                else {
                    availability = false;
                    break;
                }
            }
            else{
                availability=false;
                break;
            }
        }
        return availability;
    }

    //Questo metodo necessita la GUI per l'implementazione, quindi rimane un prototipo per ora.
    public String getSituation(LocalDate date){
        return null;
    }

    public ArrayList<Ricovero> getRicoveriAssegnati(){
        return ricoveriAssegnati;
    }
}
