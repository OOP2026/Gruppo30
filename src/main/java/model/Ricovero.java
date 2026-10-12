package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Ricovero {
    private LocalDateTime start;
    private LocalDateTime end;
    private String codicep;
    private String codiceb;
    private String idrec;
    private ArrayList<Prestazione> prestazioniassegnate;
    Letto lettoassegnato;

    public void calculatetime(){
        long d=ChronoUnit.DAYS.between(this.start, this.end);
        System.out.println("Il ricovero durera"+ d + "giorni.");
    }

    public LocalDateTime getStart(){
        return this.start;
    }

    public LocalDateTime getEnd(){
        return this.end;
    }

    public String getIdrec(){
        return this.idrec;
    }

    public void setStart(LocalDateTime news){
        this.start=news;
    }

    public void setEnd(LocalDateTime newe){
        this.end=newe;
    }

    public List<Prestazione> getPrestazioniassegnate(){
        return this.prestazioniassegnate;
    }

    public boolean isoverlapped(Ricovero compared, String bedcode) {
        if (!this.codiceb.equals(bedcode)) {
            return false;
        }
        boolean overlapstate;
        if(this.end.isBefore(compared.getStart()) || this.start.isAfter(compared.getEnd())) {
            overlapstate = false;
            return overlapstate;
        } else {
            overlapstate = true;
            return overlapstate;
        }
    }

    public Ricovero(LocalDateTime s, LocalDateTime e, String cb, String cp, String idr, Letto l){
        this.start = s;
        this.end = e;
        this.codiceb = cb;
        this.codicep = cp;
        this.idrec = idr;
        this.lettoassegnato = l;
        this.prestazioniassegnate = new ArrayList<>();
    }
}
