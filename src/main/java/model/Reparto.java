package model;

import java.util.ArrayList;

public class Reparto {
    private String nome;
    private String code;
    private ArrayList<Stanza> stanze=null;
    private ArrayList<Medico> impiegati=null;

    public void addStanza(int n, int ml){
        Stanza newstanza= new Stanza(n, ml, this);
        stanze.add(newstanza);
    }

    public void addMedico(String m, String s){
        Medico newmedic=new Medico(m, s, this);
        this.impiegati.add(newmedic);
    }

    public ArrayList<Stanza> getStanze(){
        return stanze;
    }

    public Reparto(String n, String c){
        nome=n;
        code=c;
    }
}
