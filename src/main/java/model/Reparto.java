package model;

import java.util.ArrayList;

public class Reparto {
    private String nome;
    private String code;
    private ArrayList<Stanza> stanze;
    private ArrayList<Medico> impiegati;

    public String getNome(){
        return nome;
    }
    public void addStanza(int n, int ml){
        Stanza newstanza= new Stanza(n, ml, this);
        stanze.add(newstanza);
    }

    public void addLettoToStanza(String c, int n){
        for (Stanza stanza : stanze){
            if(stanza.getNumero()==n)
                stanza.addLetto(c);

        }
    }

    public void addMedico(String u, String p, String m, String s){
        Medico newmedic=new Medico(u, p, m, s, this);
        this.impiegati.add(newmedic);
    }

    public ArrayList<Stanza> getStanze(){
        return stanze;
    }

    public Letto cercaLetto(String c){
        Letto result=null;
        for (Stanza stanza : getStanze()){
            for(Letto letto: stanza.getLetti()){
                if(c==letto.getCode())
                    result=letto;
            }
        }
        return result;
    }

    public Reparto(String n, String c){
        nome=n;
        code=c;
        stanze= new ArrayList<Stanza>();
        impiegati= new ArrayList<Medico>();
    }
}
