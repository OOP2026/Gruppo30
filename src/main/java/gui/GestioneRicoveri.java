package gui;

import controller.Controller;
import javax.swing.*;

public class GestioneRicoveri {
    private JFrame frame;
    private JPanel panelRicoveri;
    private JTextField campoCFPaziente;
    private JTextField campoCodiceLetto;
    private JTextField campoDataInizio;
    private JTextField campoDataFine;
    private JButton annullaButton;
    private JButton confermaButton;
    private JTable tabellaRicoveri;

    public GestioneRicoveri(JFrame framec, Controller controller) {
        frame = new JFrame("Gestione Ricoveri");
        frame.setContentPane(panelRicoveri);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(framec);
    }

    public String getCFPaziente() {
        if ((campoCFPaziente != null)) {
            return campoCFPaziente.getText().trim();
        }
        else{
            return "";
        }
    }

    public String getCodiceLetto() {
        if(campoCodiceLetto != null){
            return campoCodiceLetto.getText().trim();
        }
        else{
            return "";
        }
    }

    public String getDataInizio() {
        if(campoDataInizio != null){
            return campoDataInizio.getText().trim();
        }
        else{
            return "";
        }
    }

    public String getDataFine() {
        if(campoDataFine != null){
            return campoDataFine.getText().trim();
        }
        else{
            return "";
        }
    }

    public void svuotaCampi() {
        if (campoCFPaziente != null) {
            campoCFPaziente.setText("");
        }
        if (campoCodiceLetto != null) {
            campoCodiceLetto.setText("");
        }
        if (campoDataInizio != null) {
            campoDataInizio.setText("");
        }
        if (campoDataFine != null) {
            campoDataFine.setText("");
        }
    }

    public JButton getConfermaButton() {
        return confermaButton;
    }

    public JButton getAnnullaButton() {
        return annullaButton;
    }

    public JTable getTabellaRicoveri() {
        return tabellaRicoveri;
    }

    public JPanel getPanelRicoveri() {
        return panelRicoveri;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void mostraMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(frame, messaggio, "Informazione", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraErrore(String messaggio) {
        JOptionPane.showMessageDialog(frame, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void visualizza(boolean visibile) {
        frame.setVisible(visibile);
    }
}