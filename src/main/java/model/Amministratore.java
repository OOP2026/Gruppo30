package model;

import java.util.ArrayList;
import java.time.LocalDate;


public class Amministratore extends Utente {
    public void inserisciPaziente(String c, String n, String s, LocalDate d, ArrayList list){
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

    public void inserisciRicovero(LocalDate s, LocalDate e, String cb, String cp, String idr, ArrayList<Ricovero> listr){
        Ricovero ricovery=new Ricovero(s, e, cb, cp, idr);
        listr.add(ricovery);
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
        ArrayList<Ricovero> nlistr= new ArrayList<Ricovero>();
        for(int i=0;i<listr.size();i++){
            if(listr.get(i).getEnd()==date)
                nlistr.add(listr.get(i));
        }
        return nlistr;
    }

    public ArrayList<Letto> cercaLettiDisponibili(String idrep){

    }
    public Amministratore(String usn, String pw){
        super(usn, pw);
    }
}
