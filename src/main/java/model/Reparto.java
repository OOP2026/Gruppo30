package model;

import java.util.ArrayList;

public class Reparto {
    private String nome;
    private String code;
    private ArrayList<Stanza> stanze;

    public void addStanza(int n, int ml){
        Stanza newstanza= new Stanza(n, ml, this);

        stanze.add(newstanza);
    }
}
