package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prestazione {
    private final String tipo;
    private final LocalDate data;
    private final LocalTime oraInizio;
    private final LocalTime oraFine;
    private String esito;
    private String stato;
    private String descrizione;
    private final String idwork;
    Ricovero ricoveroassegnato;
    Medico medicoassegnato;
    TurnoLavorativo turno;

    public Prestazione(String t, LocalDate d, LocalTime oraInizio, LocalTime oraFine,
                       String s, String de, Ricovero r, Medico m, TurnoLavorativo tl) {
        this.tipo = t;
        this.data = d;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.idwork = s;
        this.descrizione = de;
        this.ricoveroassegnato = r;
        this.medicoassegnato = m;
        this.turno = tl;
        this.esito = "Esito Mancante";
        this.stato = "Sconosciuto";
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public String getIdwork() {
        return idwork;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String s) {
        this.esito = s;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String s) {
        this.stato = s;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String s) {
        this.descrizione = s;
    }

    public boolean convalidateshift() {
        if (this.turno == null || this.data == null || this.oraInizio == null || this.oraFine == null) {
            return false;
        }
        if (!this.turno.getData().equals(this.data)) {
            return false;
        }
        if (!this.oraInizio.isBefore(this.oraFine)) {
            return false;
        }

        boolean iniziaNelTurno = !this.oraInizio.isBefore(this.turno.getInizio());
        boolean finisceNelTurno = !this.oraFine.isAfter(this.turno.getFine());

        return iniziaNelTurno && finisceNelTurno;
    }
    public boolean siSovrappone(Prestazione altra) {
        if (altra == null || !this.data.equals(altra.getData())) {
            return false;
        }
        return this.oraInizio.isBefore(altra.getOraFine()) && this.oraFine.isAfter(altra.getOraInizio());
    }
}
