package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TurnoLavorativo {
    private LocalDate data;
    private LocalTime inizio;
    private LocalTime fine;
    Medico medicoditurno;
    ArrayList<Prestazione> prestazioniditurno;

    public LocalDate getData(){
        return data;
    }

    public LocalTime getInizio(){
        return inizio;
    }
    public LocalTime getFine(){
        return fine;
    }

    public TurnoLavorativo(LocalDate d, LocalTime i, LocalTime f, Medico m){
        data=d;
        inizio=i;
        fine=f;
        medicoditurno=m;
        prestazioniditurno=new ArrayList<>();
    }
}
