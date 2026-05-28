package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import controller.Controller;

public class GestioneRicoveri {
    private JPanel panelRicoveri;
    private JTextField campoCFPaziente;
    private JTextField campoCodiceLetto;
    private JTextField campoDataInizio;
    private JTextField campoDataFine;
    private JButton annullaButton;
    private JButton confermaButton;
    private JTable tabellaRicoveri;
    private JButton tornaButton;
    private JFrame frame;

    public GestioneRicoveri(JFrame framec, Controller controller) {
        frame=new JFrame("Gestione Ricoveri");
        frame.setVisible(true);
        frame.setContentPane(getPanelRicoveri());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(framec);


        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.aggiungiRicovero(getDataInizio(), getDataFine(), getCodiceLetto(), getCFPaziente());
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                svuotaCampi();
            }
        });

        tornaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framec.setVisible(true);
                frame.dispose();
            }
        });
    }

    public JPanel getPanelRicoveri() {
        return panelRicoveri;
    }
    public String getCFPaziente() { return campoCFPaziente.getText(); }
    public String getCodiceLetto() { return campoCodiceLetto.getText(); }
    public LocalDate getDataInizio() { return LocalDate.parse(campoDataInizio.getText()); }
    public LocalDate getDataFine() { return LocalDate.parse(campoDataFine.getText()); }

    public JTable getTabellaRicoveri() { return tabellaRicoveri; }

    public void svuotaCampi() {
        campoCFPaziente.setText("");
        campoCodiceLetto.setText("");
        campoDataInizio.setText("");
        campoDataFine.setText("");
    }
}