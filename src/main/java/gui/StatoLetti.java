package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatoLetti {
    private JPanel panelStatoLetti;
    private JButton CercaBtn;
    private JTable tabellaLetti;
    private JComboBox comboReparti;
    private JButton btnIndietro;

    public StatoLetti() {
        CercaBtn.addActionListener(new ActionListener() {
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

    public JPanel getPanelStatoLetti() {
        return panelStatoLetti;
    }

    public JComboBox getComboReparti() {
        return comboReparti;
    }

    public JTable getTabellaLetti() {
        return tabellaLetti;
    }
}