package model;


import java.util.ArrayList;
import java.time.LocalDate;

public class main {
    public static void main(String[] args){
        Utente abc= new Utente("ciao", "arrivederci");
        boolean test;
        test=abc.login("arrivederci","ciao");
        System.out.println(test);
        test=abc.login("ciao","arrivederci");
        System.out.println(test);

        LocalDate testdate= LocalDate.of(2004,12,9);
        LocalDate testdate2= LocalDate.of(2003, 07, 20);

        Amministratore a=new Amministratore("addio","byebye");
        ArrayList<Paziente> lista= new ArrayList();
        a.inserisciPaziente("abc","el","cor",testdate, lista);
        a.inserisciPaziente("cam","bar","qua",testdate, lista);

        System.out.println(lista.get(0).getNome());

        a.modificaPaziente("abc","awww","crs",testdate2, lista);

        System.out.println(lista.get(0).getNome());

        System.out.println(lista.size());


    }

}