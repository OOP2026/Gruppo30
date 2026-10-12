package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Letto {
    private final String code;
    Stanza s;
    ArrayList<Ricovero> ricoveriAssegnati;

    public Letto(String c, Stanza s){
        code=c;
        this.s=s;
        this.ricoveriAssegnati = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public boolean isAvailable(LocalDateTime d1, LocalDateTime d2) {
        if (ricoveriAssegnati == null || ricoveriAssegnati.isEmpty()) {
            return true;
        }

        for (Ricovero ricovero : ricoveriAssegnati) {
            boolean terminaPrima = d2.isBefore(ricovero.getStart());
            boolean iniziaDopo = d1.isAfter(ricovero.getEnd());
            if (!terminaPrima && !iniziaDopo) {
                return false;
            }
        }
        return true;
    }

    public List<Ricovero> getRicoveriAssegnati(){
        return ricoveriAssegnati;
    }
}
