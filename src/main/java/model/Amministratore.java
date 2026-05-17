package model;

import java.util.ArrayList;
import java.time.LocalDate;


public class Amministratore extends Utente {
    public void inserisciPaziente(String c, String n, String s, LocalDate d, ArrayList<Paziente> list){
        Paziente patient=new Paziente(c, n, s, d);
        list.add(patient);
    }

    public void modificaPaziente(String c, String n, String s, LocalDate d, ArrayList<Paziente> list){

        for(int i=0;i<list.size();i++){
            if(c.equals(list.get(i).getCodiceFiscale())) {
                list.get(i).setNome(n);
                list.get(i).setCognome(s);
                list.get(i).setDataNascita(d);
            }
        }
    }

//Questo metodo inizializza un ricovero e lo assegna ad un letto.

    public void inserisciRicovero(LocalDate s, LocalDate e, String cb, String cp, String idr, Letto l){
        Ricovero ricovery=new Ricovero(s, e, cb, cp, idr, l);
        l.getRicoveriAssegnati().add(ricovery);

    }

    public void modificaRicovero(String idr, LocalDate ns, LocalDate ne, ArrayList<Ricovero> listr){
        for(int i=0;i<listr.size();i++){
            if(idr.equals(listr.get(i).getIdrec())){
                listr.get(i).setStart(ns);
                listr.get(i).setEnd(ne);
            }
        }
    }

    public ArrayList<Ricovero> getPazientiInScadenza(LocalDate date, ArrayList<Ricovero> listr){
        ArrayList<Ricovero> nlistr= new ArrayList<>();
        for(int i=0;i<listr.size();i++){
            if(listr.get(i).getEnd()==date)
                nlistr.add(listr.get(i));
        }
        return nlistr;
    }

    public ArrayList<Letto> cercaLettiDisponibili(ArrayList<Stanza> lists){
        ArrayList<Letto> listl=new ArrayList<>();
        LocalDate d1=LocalDate.of(2026,5,2);
        LocalDate d2=LocalDate.of(2026,5,2);
        for(int i=0; i<lists.size();i++){
            listl.addAll(lists.get(i).listaDisponibili(d1,d2));
        }
        return listl;
    }
    public Amministratore(String usn, String pw){
        super(usn, pw);
    }
}
