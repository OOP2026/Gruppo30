package model;

import java.time.LocalDate;
enum StatoPrestazione{
    Programmata,
    Eseguita,
    Annullata
}
public class Prestazione {
    private String tipo;
    private LocalDate data;
    private String esito;
    private StatoPrestazione stato;
    private String descrizione;

    public boolean convalidateshift(){}
}
