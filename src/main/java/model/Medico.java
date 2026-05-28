package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Utente{
    private String matricola;
    private String specializzazione;
    private ArrayList<Prestazione> prestazioni;
    Reparto r;
    ArrayList<TurnoLavorativo> turniassegnati;


    public ArrayList<Prestazione> viewagenda(LocalDate date){
        ArrayList<Prestazione> listp=new ArrayList<>();

        for(int i=0; i<prestazioni.size();i++){
            if(prestazioni.get(i).getData()==date)
                listp.add(prestazioni.get(i));
        }
        return listp;
    }
    public void registeroperation(String t, LocalDate d, String s, String de, Ricovero r, TurnoLavorativo tl){
        Prestazione work=new Prestazione(t, d, s, de, r, this, tl);
        r.getPrestazioniassegnate().add(work);
        this.prestazioni.add(work);
    }
    public void completeoperation(String idp, String text){
        for(int i=0; i<prestazioni.size();i++){
            if(idp==prestazioni.get(i).getIdwork())
                prestazioni.get(i).setEsito(text);
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
        prestazioni=new ArrayList<Prestazione>();
        turniassegnati=new ArrayList<TurnoLavorativo>();
    }
}
