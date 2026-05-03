package model;

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
    }

    public void addLetto(String c){
        Letto newletto= new Letto(c, this);
        letti.add(newletto);
    }
}
