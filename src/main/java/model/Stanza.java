package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Stanza {
    private int numero;
    private int maxletti;
    Reparto r;
    private ArrayList<Letto> letti;

    public Stanza(int n, int ml, Reparto r){
        numero=n;
        maxletti=ml;
        this.r=r;
        letti=new ArrayList<>();
    }

    public void addLetto(String c){
        Letto newletto= new Letto(c, this);
        letti.add(newletto);
    }

    public ArrayList<Letto> getLetti(){
        return letti;
    }

    public int getNumero(){
        return numero;
    }

    public ArrayList<Letto> listaDisponibili(LocalDate d1, LocalDate d2){
        ArrayList<Letto> newlist= new ArrayList<>();
        for(int i=0;i<letti.size();i++){
            if(letti.get(i).isAvailable(d1,d2))
                newlist.add(letti.get(i));
        }
        return newlist;
    }
}
