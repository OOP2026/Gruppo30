package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ricovero {
    private LocalDate start;
    private LocalDate end;
    private String codicep;
    private String codiceb;
    private String idrec;

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

    public boolean isoverlapped(Ricovero compared, String bedcode){
        boolean overlapstate=false;
        if(bedcode==codiceb) {
            if(start.isAfter(compared.getStart())&&start.isBefore(compared.getEnd()))
                overlapstate=true;
        }
        return overlapstate;
    }

    public Ricovero(LocalDate s, LocalDate e, String cb, String cp, String idr){
        start=s;
        end=e;
        codiceb=cb;
        codicep=cp;
        idrec=idr;
    }
}
