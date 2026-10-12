package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medico extends Utente{
    private final String matricola;
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

    public ArrayList<Prestazione> viewAgendaSettimanale(LocalDate dataInizio) {
        ArrayList<Prestazione> listp = new ArrayList<>();
        LocalDate dataFine = dataInizio.plusDays(6);

        for (Prestazione prestazione : prestazioni) {
            LocalDate d = prestazione.getData();
            if (!d.isBefore(dataInizio) && !d.isAfter(dataFine)) {
                listp.add(prestazione);
            }
        }
        return listp;
    }
    public boolean registraPrestazione(String tipo, LocalDate data, LocalTime oraInizio, LocalTime oraFine,
                                       String id, String descr, Ricovero ricovero, TurnoLavorativo turno) {

        Prestazione nuovaPrestazione = new Prestazione(tipo, data, oraInizio, oraFine, id, descr, ricovero, this, turno);

        if (!nuovaPrestazione.convalidateshift()) {
            return false;
        }
        for (Prestazione p : this.prestazioni) {
            if (p.siSovrappone(nuovaPrestazione)) {
                return false;
            }
        }
        this.prestazioni.add(nuovaPrestazione);
        if (ricovero != null && ricovero.getPrestazioniassegnate() != null) {
            ricovero.getPrestazioniassegnate().add(nuovaPrestazione);
        }
        return true;
    }
    public void completaOperazione(String idp, String text){
        for(Prestazione prestazione : prestazioni){
            if(idp.equals(prestazione.getIdwork()))
                prestazione.setEsito(text);
        }
    }
    public ArrayList<Prestazione> getPrestazioni(){
        return prestazioni;
    }

    public Medico(String usn, String pw, String m, Reparto r){
        super(usn,pw);
        matricola=m;
        this.r=r;
        prestazioni=new ArrayList<>();
        turniassegnati=new ArrayList<>();
    }
}
