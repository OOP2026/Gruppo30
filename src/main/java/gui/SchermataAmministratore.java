package gui;

import controller.Controller;
import javax.swing.*;

public class SchermataAmministratore {
    private JFrame frame;
    private JPanel panelAdmin;
    private JButton gestionePazientiButton;
    private JButton gestioneRicoveriButton;
    private JButton ricercaDimissioniButton;
    private JButton statoLettiButton;
    private JLabel adminSchermataText;

    public SchermataAmministratore(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Area Amministratore");
        frame.setContentPane(panelAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public JButton getGestionePazientiButton() {
        return gestionePazientiButton;
    }

    public JButton getGestioneRicoveriButton() {
        return gestioneRicoveriButton;
    }

    public JButton getRicercaDimissioniButton() {
        return ricercaDimissioniButton;
    }

    public JButton getStatoLettiButton() {
        return statoLettiButton;
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