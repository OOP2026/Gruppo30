package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchermataAmministratore {
    private JButton gestionePazientiButton;
    private JButton gestioneRicoveriButton;
    private JButton ricercaDimissioniButton;
    private JButton statoLettiButton;
    private JPanel PanelAdmin;

    public SchermataAmministratore() {
        gestionePazientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Gestione Pazienti");
                //controller
            }
        });

        gestioneRicoveriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Gestione Ricoveri");
                //controller
            }
        });

        ricercaDimissioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Ricerca Dimissioni");
                //controller
            }
        });

        statoLettiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Stato Letti");
                //controller
            }
        });
    }

    public JPanel getPanelAdmin() {
        return PanelAdmin;
    }
}