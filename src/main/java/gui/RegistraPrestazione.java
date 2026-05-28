package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class RegistraPrestazione {
    private JPanel panelRegistraPrestazione;
    private JTextArea campoTipo; // Usata per il risultato/note
    private JButton salvaButton;
    private JButton annullaButton;
    private JTextField campoData; // Rinominata correttamente!
    private JTextField textField2; // Usata per il tipo di prestazione
    private JTextField textField3;
    private JFrame frame;

    public RegistraPrestazione(JFrame framec, Controller controller) {
        frame= new JFrame("Registra Prestazione");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getPanelRegistraPrestazione());
        frame.pack();
        frame.setLocationRelativeTo(framec);
        frame.setVisible(true);

            salvaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.creaPrestazione(getTipoPrestazione(), getData(), getRisultato(), getID());
                }
            });

            annullaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    framec.setVisible(true);
                    frame.dispose();
                }
            });
        }

        public JPanel getPanelRegistraPrestazione() {
            return panelRegistraPrestazione;
        }

        public LocalDate getData() {
            return LocalDate.parse(campoData.getText());
        }

        public String getTipoPrestazione() {
            return textField2.getText();
        }

        public String getRisultato() {
            return campoTipo.getText();
        }

        public String getID(){
        return textField3.getText();
        }

        public void svuotaCampi() {
            campoData.setText("");
            textField2.setText("");
            campoTipo.setText("");
            textField3.setText("");
        }
    }