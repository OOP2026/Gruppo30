package model;

import java.util.ArrayList;
import java.time.LocalDate;


public class Amministratore extends Utente {
    public void inserisciPaziente(String c, String n, String s, LocalDate d, ArrayList<Paziente> list){
        Paziente patient=new Paziente(c, n, s, d);
        list.add(patient);
    }

    public void modificaPaziente(String c, String n, String s, LocalDate d, ArrayList<Paziente> list){

        for (Paziente paziente : list) {
            if (c.equals(paziente.getCodiceFiscale())) {
                paziente.setNome(n);
                paziente.setCognome(s);
                paziente.setDataNascita(d);
            }
        }
    }

//Questo metodo inizializza un ricovero e lo assegna ad un letto.

    public void inserisciRicovero(LocalDate s, LocalDate e, String cb, String cp, String idr, Letto l){
        Ricovero ricovery=new Ricovero(s, e, cb, cp, idr, l);
        l.getRicoveriAssegnati().add(ricovery);

    }

    public void modificaRicovero(String idr, LocalDate ns, LocalDate ne, ArrayList<Ricovero> listr){
        for (Ricovero ricovero : listr) {
            if (idr.equals(ricovero.getIdrec())) {
                ricovero.setStart(ns);
                ricovero.setEnd(ne);
            }
        }
    }

    public ArrayList<Ricovero> getPazientiInScadenza(LocalDate date, ArrayList<Ricovero> listr){
        ArrayList<Ricovero> nlistr= new ArrayList<>();
        for(Ricovero ricovero : listr){
            if(ricovero.getEnd()==date)
                nlistr.add(ricovero);
        }

        return nlistr;
    }

    public ArrayList<Letto> cercaLettiDisponibili(ArrayList<Stanza> lists){
        ArrayList<Letto> listl=new ArrayList<>();
        LocalDate d1=LocalDate.of(2026,5,2);
        LocalDate d2=LocalDate.of(2026,5,2);
        for(Stanza stanza : lists){
            listl.addAll(stanza.listaDisponibili(d1,d2));
        }
        return listl;
    }
    public Amministratore(String usn, String pw){
        super(usn, pw);
    }
}
