package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraPrestazione {
    private JPanel panelRegistraPrestazione;
    private JTextArea campoTipo; // Usata per il risultato/note
    private JButton salvaButton;
    private JButton annullaButton;
    private JTextField campoData; // Rinominata correttamente!
    private JTextField textField2; // Usata per il tipo di prestazione

        public RegistraPrestazione() {
            salvaButton.addActionListener(new ActionListener() {
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

        public JPanel getPanelRegistraPrestazione() {
            return panelRegistraPrestazione;
        }

        public String getData() {
            return campoData.getText();
        }

        public String getTipoPrestazione() {
            return textField2.getText();
        }

        public String getRisultato() {
            return campoTipo.getText();
        }

        public void svuotaCampi() {
            campoData.setText("");
            textField2.setText("");
            campoTipo.setText("");
        }
    }