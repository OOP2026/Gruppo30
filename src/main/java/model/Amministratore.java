package model;

import java.util.ArrayList;
import java.time.LocalDate;


public class Amministratore extends Utente {
    private ArrayList<Reparto> reparti;

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
    public Paziente cercaPaziente(String c, ArrayList<Paziente> p){
        Paziente result=null;
        for(Paziente paziente : p){
            if (c.equals(paziente.getCodiceFiscale())) {
                result=paziente;
            }
        }
        return result;
    }

//Questo metodo inizializza un ricovero e lo assegna ad un letto.

    public void inserisciRicovero(LocalDate s, LocalDate e, Letto l, Paziente p, String idr){
        Ricovero ricovery=new Ricovero(s, e,l, p, idr);
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

    public ArrayList<Paziente> getPazientiInScadenza(LocalDate date, ArrayList<Ricovero> listr){
        ArrayList<Paziente> nlistp= new ArrayList<>();
        for (Ricovero ricovero : listr) {
            if (ricovero.getEnd() == date)
                nlistp.add(ricovero.getpazienteassegnato());
        }
        return nlistp;
    }

    public ArrayList<Letto> cercaLettiDisponibili(ArrayList<Stanza> lists){
        ArrayList<Letto> listl=new ArrayList<>();
        LocalDate d1=LocalDate.of(2026,5,2);
        LocalDate d2=LocalDate.of(2026,5,2);
        for (Stanza list : lists) {
            listl.addAll(list.listaDisponibili(d1, d2));
        }
        return listl;
    }
    public Reparto cercaReparto(String n){
        Reparto reparto=null;
        for (Reparto reparto2 : reparti){
            if(n==reparto2.getNome())
                reparto=reparto2;
        }
        return reparto;
    }
    public ArrayList<Letto> cercaLetti(ArrayList<Stanza> lists){
        ArrayList<Letto> listl=new ArrayList<>();
        for (Stanza stanza : lists){
            listl.addAll(stanza.getLetti());
        }
        return listl;
    }
    public Reparto creaReparto(String n, String a){
        Reparto reparto=new Reparto(n, a);
        reparti.add(reparto);
        return reparto;
    }
    public ArrayList<Paziente> allPazientiInScadenza(LocalDate date){
        ArrayList<Paziente> listaPazienti= new ArrayList<>();
        for (Reparto reparto : reparti){
            for (Stanza stanza : reparto.getStanze()){
                for(Letto letto : stanza.getLetti()){
                    listaPazienti.addAll(getPazientiInScadenza(date, letto.getRicoveriAssegnati()));
                }
            }
        }
        return listaPazienti;
    }

    public ArrayList<Reparto> getreparti(){
        return reparti;
    }
    public Amministratore(String usn, String pw){
        super(usn, pw);
        reparti=new ArrayList<>();
    }
}
