package gui;

import controller.Controller;
import javax.swing.*;

public class RicercaDimissioni {
    private JFrame frame;
    private JPanel panelDimissioni;
    private JButton btnCercaDimissioni;
    private JTable tabellaDimissioni;
    private JButton btnIndietro;
    private JTextField dataRicerca;
    private JLabel campoDataRicerca;

    public RicercaDimissioni(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Ricerca Pazienti in Dimissione");
        frame.setContentPane(panelDimissioni);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public String getDataRicerca() {
        if(dataRicerca != null){
           return dataRicerca.getText().trim();
        }
        else{
            return "";
        }
    }

    public void svuotaCampi() {
        if (dataRicerca != null) {
            dataRicerca.setText("");
        }
    }

    public JButton getBtnCercaDimissioni() {
        return btnCercaDimissioni;
    }

    public JButton getBtnIndietro() {
        return btnIndietro;
    }

    public JTable getTabellaDimissioni() {
        return tabellaDimissioni;
    }

    public JPanel getPanelDimissioni() {
        return panelDimissioni;
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