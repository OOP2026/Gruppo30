package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Ricovero {
    private LocalDate start;
    private LocalDate end;
    private String codicep;
    private String codiceb;
    private String idrec;
    private ArrayList<Prestazione> prestazioniassegnate=null;
    Letto lettoassegnato;
    // Non ho trovato necessario implementare l'associazione tra paziente e ricovero, in quanto sarebbe inutile ai fini del programma.


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

    public ArrayList<Prestazione> getPrestazioniassegnate(){
        return prestazioniassegnate;
    }

    public boolean isoverlapped(Ricovero compared, String bedcode){
        boolean overlapstate=false;
        if(bedcode==codiceb) {
            if(start.isAfter(compared.getStart())&&start.isBefore(compared.getEnd()))
                overlapstate=true;
        }
        return overlapstate;
    }

    public Ricovero(LocalDate s, LocalDate e, String cb, String cp, String idr, Letto l){
        start=s;
        end=e;
        codiceb=cb;
        codicep=cp;
        idrec=idr;
        lettoassegnato=l;
    }
}
