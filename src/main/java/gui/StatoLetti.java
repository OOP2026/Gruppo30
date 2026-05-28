package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;

public class StatoLetti {
    private JPanel panelStatoLetti;
    private JButton CercaBtn;
    private JTable tabellaLetti;
    private JComboBox comboReparti;
    private JButton btnIndietro;
    private JFrame frame;

    public StatoLetti(JFrame framec, Controller controller) {
        frame= new JFrame("Stato Letti");
        frame.setVisible(true);
        frame.setContentPane(getPanelStatoLetti());
        frame.setLocationRelativeTo(framec);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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