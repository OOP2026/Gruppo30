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
        int d=ChronoUnit.DAYS.between(end,start);
        System.out.println("Il ricovero durera" d + "giorni.");
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
        if(bedcode==codiceb) {
            if(start.isAfter(compared.getStart())&&start.isBefore(compared.getEnd()))
                return true;
            else
                return false;
        }
    }

    public Ricovero(LocalDate s, LocalDate e, String cb, String cp, String idr){
        start=s;
        end=e;
        codiceb=cb;
        codicep=cp;
        idrec=idr;
    }
}
