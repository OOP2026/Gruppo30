package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RicercaDimissioni {
    private JPanel panelDimissioni;
    private JButton btnCercaDimissioni;
    private JTable tabellaDimissioni;
    private JButton btnIndietro;
    private JTextField textField1;
    private JLabel campoDataRicerca;

    public RicercaDimissioni() {
        btnCercaDimissioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });

        btnIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Controller
            }
        });
    }

    public JPanel getPanelDimissioni() {
        return panelDimissioni;
    }

    public String getDataRicerca() {
        return textField1.getText();
    }

    public JTable getTabellaDimissioni() {
        return tabellaDimissioni;
    }
}