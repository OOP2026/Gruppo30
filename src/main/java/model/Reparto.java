package model;

import java.util.ArrayList;
import java.util.List;

public class Reparto {
    private final String nome;
    private final String code;
    private ArrayList<Stanza> stanze;
    private ArrayList<Medico> impiegati;

    public String getNome() {
        return nome;
    }

    public String getCode() {
        return code;
    }

    public List<Medico> getImpiegati() {
        return impiegati;
    }

    public void addStanza(int n, int ml){
        Stanza newstanza= new Stanza(n, ml, this);
        stanze.add(newstanza);
    }

    public void addMedico(String u, String p, String m, String s){
        Medico newmedic=new Medico(u, p, m, s, this);
        this.impiegati.add(newmedic);
    }

    public List<Stanza> getStanze(){
        return stanze;
    }

    public Reparto(String n, String c){
        nome=n;
        code=c;
        stanze= new ArrayList<>();
        impiegati= new ArrayList<>();
    }
}
