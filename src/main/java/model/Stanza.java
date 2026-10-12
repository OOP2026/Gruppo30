package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Stanza {
    private int numero;
    private int maxletti;
    Reparto r;
    private ArrayList<Letto> letti;

    public Stanza(int n, int ml, Reparto r){
        this.numero = n;
        this.maxletti = ml;
        this.r = r;
        this.letti = new ArrayList<>();
    }

    public void addLetto(String c){
        if (letti.size() < maxletti) {
            Letto newletto = new Letto(c, this);
            letti.add(newletto);
        } else {
            System.out.println("Numero massimo di letti raggiunto per la stanza " + numero);
        }
    }

    public List<Letto> getLetti(){
        return letti;
    }

    public List<Letto> listaDisponibili(LocalDateTime d1, LocalDateTime d2){
        ArrayList<Letto> newlist= new ArrayList<>();
        for(int i=0;i<letti.size();i++){
            if(letti.get(i).isAvailable(d1,d2))
                newlist.add(letti.get(i));
        }
        return newlist;
    }
}
