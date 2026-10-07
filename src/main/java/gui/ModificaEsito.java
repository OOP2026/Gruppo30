package gui;

import controller.Controller;
import javax.swing.*;

public class ModificaEsito {
    private JFrame frame;
    private JPanel panelModificaEsito;
    private JLabel labelPaziente;
    private JTextArea areaEsito;
    private JTextArea areaPrestazioni;
    private JButton salvaButton;
    private JButton annullaButton;

    public ModificaEsito(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Modifica Esito Prestazione");
        frame.setContentPane(panelModificaEsito);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (areaPrestazioni != null) {
            areaPrestazioni.setEditable(false);
        }

        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public String getEsito() {
        return (areaEsito != null) ? areaEsito.getText().trim() : "";
    }

    public void setEsito(String esito) {
        if (areaEsito != null) {
            areaEsito.setText(esito);
        }
    }

    public void setPazienteInfo(String infoPaziente) {
        if (labelPaziente != null) {
            labelPaziente.setText(infoPaziente);
        }
    }

    public void setDettagliPrestazione(String dettagli) {
        if (areaPrestazioni != null) {
            areaPrestazioni.setText(dettagli);
        }
    }

    public void svuotaCampi() {
        if (areaEsito != null) {
            areaEsito.setText("");}
    }

    public JButton getSalvaButton() {
        return salvaButton;
    }

    public JButton getAnnullaButton() {
        return annullaButton;
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