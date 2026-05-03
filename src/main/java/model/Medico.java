package model;

import java.util.ArrayList;

public class Medico {
    private String matricola;
    private String specializzazione;

    public ArrayList viewagenda(){}
    public void registeroperation(String idr){}
    public void completeoperation(String idp, String text){}

    public Medico(String m, String s){
        matricola=m;
        specializzazione=s;
    }
}
