package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Ricovero {
    private LocalDate start;
    private LocalDate end;
    private String idrec;
    private ArrayList<Prestazione> prestazioniassegnate;
    Letto lettoassegnato;
    Paziente pazienteassegnato;



    public void calculatetime(){
        long d=ChronoUnit.DAYS.between(end,start);
        System.out.println("Il ricovero durera"+ d + "giorni.");
    }

    public LocalDate getStart(){
        return start;
    }

    public LocalDate getEnd(){
        return end;
    }

    public String getIdrec(){
        return idrec;
    }

    public void setStart(LocalDate news){
        start=news;
    }

    public void setEnd(LocalDate newe){
        end=newe;
    }

    public Paziente getpazienteassegnato(){return pazienteassegnato;}

    public ArrayList<Prestazione> getPrestazioniassegnate(){
        return prestazioniassegnate;
    }

    public boolean isoverlapped(Ricovero compared, String bedcode){
        boolean overlapstate=false;
        if(bedcode.equals(lettoassegnato.getCode())&&start.isAfter(compared.getStart())&&start.isBefore(compared.getEnd()))
                overlapstate=true;

        return overlapstate;
    }

    public Ricovero(LocalDate s, LocalDate e, Letto l, Paziente p, String idr){
        start=s;
        end=e;
        idrec=idr;
        lettoassegnato=l;
        pazienteassegnato=p;
        prestazioniassegnate = new ArrayList<>();
    }
}
