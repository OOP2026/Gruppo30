package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneRicoveri {
    private JPanel panelRicoveri;
    private JTextField campoCFPaziente;
    private JTextField campoCodiceLetto;
    private JTextField campoDataInizio;
    private JTextField campoDataFine;
    private JButton annullaButton;
    private JButton confermaButton;
    private JTable tabellaRicoveri;

    public GestioneRicoveri() {
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });
    }

    public JPanel getPanelRicoveri() {
        return panelRicoveri;
    }
    public String getCFPaziente() { return campoCFPaziente.getText(); }
    public String getCodiceLetto() { return campoCodiceLetto.getText(); }
    public String getDataInizio() { return campoDataInizio.getText(); }
    public String getDataFine() { return campoDataFine.getText(); }

    public JTable getTabellaRicoveri() { return tabellaRicoveri; }

    public void svuotaCampi() {
        campoCFPaziente.setText("");
        campoCodiceLetto.setText("");
        campoDataInizio.setText("");
        campoDataFine.setText("");
    }
}