package gui;

import controller.Controller;
import javax.swing.*;

public class GestionePazienti {
    private JPanel panelPazienti;
    private JButton annullaButton;
    private JButton confermaButton;
    private JTextField nomeText;
    private JTextField cognomeText;
    private JTextField cfText;
    private JTextField dateText;
    private JTable tabellaPazienti;
    private JLabel campoNome;
    private JLabel campoCognome;
    private JLabel campoCF;
    private JLabel campoData;
    private JLabel gestionePazienti;
    private JFrame frame;

    public GestionePazienti(JFrame framec, Controller controller) {
        frame = new JFrame("Gestione Pazienti");
        frame.setContentPane(panelPazienti);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(framec);
    }

    public String getNome() {
        if(nomeText != null){
            return nomeText.getText().trim();
        }
        else {
            return "";
        }
    }

    public String getCognome() {
        if(cognomeText != null){
            return cognomeText.getText().trim();
        }
        else{
            return "";
        }
    }

    public String getCodiceFiscale() {
        if(cfText != null){
           return cfText.getText().trim();
        }
        else{
            return "";
        }
    }

    public String getDataNascita() {
        if(dateText != null){
            return dateText.getText().trim();
        }
        else{
            return "";
        }
    }

    public void svuotaCampi() {
        if (nomeText != null) nomeText.setText("");
        if (cognomeText != null) cognomeText.setText("");
        if (cfText != null) cfText.setText("");
        if (dateText != null) dateText.setText("");
    }

    public JButton getConfermaButton() {
        return confermaButton;
    }

    public JButton getAnnullaButton() {
        return annullaButton;
    }

    public JTable getTabellaPazienti() {
        return tabellaPazienti;
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