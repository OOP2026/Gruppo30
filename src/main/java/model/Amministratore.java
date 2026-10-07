package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Amministratore extends Utente {
    public Amministratore(String usn, String pw) {
        super(usn, pw);
    }

    public void inserisciPaziente(String cf, String nome, String cognome, LocalDate dataNascita, List<Paziente> listaPazienti) {
        Paziente patient = new Paziente(cf, nome, cognome, dataNascita);
        listaPazienti.add(patient);
    }

    public boolean modificaPaziente(String cf, String nome, String cognome, LocalDate dataNascita, List<Paziente> listaPazienti) {
        for (Paziente paziente : listaPazienti) {
            if (cf.equalsIgnoreCase(paziente.getCodiceFiscale())) {
                paziente.setNome(nome);
                paziente.setCognome(cognome);
                paziente.setDataNascita(dataNascita);
                return true;
            }
        }
        return false;
    }

    public void inserisciRicovero(LocalDate inizio, LocalDate fine, String codBed, String codPaziente, String idRicovero, Letto letto) {
        Ricovero ricovero = new Ricovero(inizio, fine, codBed, codPaziente, idRicovero, letto);
        letto.getRicoveriAssegnati().add(ricovero);
    }

    public boolean modificaRicovero(String idRicovero, LocalDate nuovoInizio, LocalDate nuovaFine, List<Ricovero> listaRicoveri) {
        for (Ricovero ricovero : listaRicoveri) {
            if (idRicovero.equals(ricovero.getIdrec())) {
                ricovero.setStart(nuovoInizio);
                ricovero.setEnd(nuovaFine);
                return true;
            }
        }
        return false;
    }

    public List<Ricovero> getPazientiInScadenza(LocalDate dataScadenza, List<Ricovero> listaRicoveri) {
        List<Ricovero> scaduti = new ArrayList<>();
        for (Ricovero ricovero : listaRicoveri) {
            if (ricovero.getEnd().equals(dataScadenza)) {
                scaduti.add(ricovero);
            }
        }
        return scaduti;
    }

    public List<Letto> cercaLettiDisponibili(LocalDate inizio, LocalDate fine, List<Stanza> listaStanze) {
        List<Letto> lettiDisponibili = new ArrayList<>();
        for (Stanza stanza : listaStanze) {
            lettiDisponibili.addAll(stanza.listaDisponibili(inizio, fine));
        }
        return lettiDisponibili;
    }
}