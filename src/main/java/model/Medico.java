package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Utente{
    private final String matricola;
    private String specializzazione;
    private ArrayList<Prestazione> prestazioni;
    Reparto r;
    ArrayList<TurnoLavorativo> turniassegnati;

    public String getMatricola() {
        return matricola;
    }

    public ArrayList<Prestazione> viewagenda(LocalDate date){
        ArrayList<Prestazione> listp=new ArrayList<>();

        for(Prestazione prestazione : prestazioni){
            if(prestazione.getData().isEqual(date))
                listp.add(prestazione);
        }
        return listp;
    }
    public void registeroperation(String t, LocalDate d, String s, String de, Ricovero r, TurnoLavorativo tl){
        Prestazione work=new Prestazione(t, d, s, de, r, this, tl);
        r.getPrestazioniassegnate().add(work);
        this.prestazioni.add(work);
    }
    public void completeoperation(String idp, String text){
        for(Prestazione prestazione : prestazioni){
            if(idp.equals(prestazione.getIdwork()))
                prestazione.setEsito(text);
        }
    }

    public ArrayList<Prestazione> getPrestazioni(){
        return prestazioni;
    }


    public Medico(String usn, String pw, String m, String s, Reparto r){
        super(usn,pw);
        matricola=m;
        specializzazione=s;
        this.r=r;
        prestazioni=new ArrayList<>();
        turniassegnati=new ArrayList<>();
    }
}
