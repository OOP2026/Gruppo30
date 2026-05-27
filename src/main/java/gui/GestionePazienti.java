package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionePazienti {
    private JPanel panelPazienti;
    private JButton annullaButton;
    private JButton confermaButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTable tabellaPazienti;
    private JLabel campoNome;
    private JLabel campoCognome;
    private JLabel campoCF;
    private JLabel campoData;
    private JLabel gestionePazienti;

    public GestionePazienti() {
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

    public JPanel getPanelPazienti() {
        return panelPazienti;
    }

    public String getNome() { return textField1.getText(); }
    public String getCognome() { return textField2.getText(); }
    public String getCodiceFiscale() { return textField3.getText(); }
    public String getDataNascita() { return textField4.getText(); }

    public void svuotaCampi() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }

    public JTable getTabellaPazienti() {
        return tabellaPazienti;
    }
}