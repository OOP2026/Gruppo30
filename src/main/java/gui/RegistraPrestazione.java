package gui;

import controller.Controller;

import javax.swing.*;
import java.time.LocalTime;

public class RegistraPrestazione {
    private JFrame frame;
    private JPanel panelRegistraPrestazione;
    private JTextArea campoNote;
    private JButton salvaButton;
    private JButton annullaButton;
    private JTextField campoData;
    private JTextField tipoPrestazione;
    private JLabel dataPrestazioneText;
    private JLabel tipoPrestazioneText;
    private JLabel labelPrestazioni;
    private JLabel noteLabel;
    private JTextField oraFineField;
    private JTextField oraInizioField;
    private JLabel oraInizioLabel;
    private JLabel oraFineLabel;

    public RegistraPrestazione(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Registra Prestazione Medica");
        frame.setContentPane(panelRegistraPrestazione);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public String getData() {
        if (campoData != null) {
            return campoData.getText().trim();
        } else {
            return "";
        }
    }

    public String getTipoPrestazione() {
        if (tipoPrestazione != null) {
            return tipoPrestazione.getText().trim();
        } else {
            return "";
        }
    }

    public String getNote() {
        if (campoNote != null) {
            return campoNote.getText().trim();
        } else {
            return "";
        }
    }

    public void svuotaCampi() {
        if (campoData != null) {
            campoData.setText("");
        }
        if (tipoPrestazione != null) {
            tipoPrestazione.setText("");
        }
        if (campoNote != null) {
            campoNote.setText("");
        }
    }
    public String getOraInizio() {
        if (oraInizioField != null) {
            return oraInizioField.getText().trim();
        } else {
            return "";
        }
    }

    public String getOraFine() {
        if (oraFineField != null) {
            return oraFineField.getText().trim();
        } else {
            return "";
        }
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