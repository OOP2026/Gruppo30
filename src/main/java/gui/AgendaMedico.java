package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaMedico {
    private JPanel panelAgenda;
    private JButton btnAggiorna;
    private JTable tabellaAgenda;
    private JButton btnLogOut;
    private JButton btnEffettuaVisita;
    private JTextField textField1;
    private JLabel campoDataAgenda;

    public AgendaMedico() {
        btnAggiorna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });

        btnEffettuaVisita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });
    }

    public JPanel getPanelAgenda() {
        return panelAgenda;
    }

    public String getDataSelezionata() {
        return textField1.getText();
    }

    public JTable getTabellaAgenda() {
        return tabellaAgenda;
    }
}