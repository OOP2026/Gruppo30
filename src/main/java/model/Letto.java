package model;

import java.time.LocalDate;

public class Letto {
    private String code;
    Stanza s;

    public Letto(String c, Stanza s){
        code=c;
        this.s=s;
    }


    public boolean isAvailable(LocalDate d1, LocalDate d2){}

    public String getSituation(LocalDate date){

    }
}
