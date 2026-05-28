package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;

public class RicercaDimissioni {
    private JPanel panelDimissioni;
    private JButton btnCercaDimissioni;
    private JTable tabellaDimissioni;
    private JButton btnIndietro;
    private JTextField textField1;
    private JLabel campoDataRicerca;
    private JFrame frame;

    public RicercaDimissioni(JFrame framec, Controller controller) {
        frame= new JFrame("Ricerca Dimissioni");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getPanelDimissioni());
        frame.pack();
        frame.setLocationRelativeTo(framec);
        frame.setVisible(true);


        btnCercaDimissioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modeltabella= (DefaultTableModel) tabellaDimissioni.getModel();
                ArrayList lista = controller.viewPazientiInDimissione(getDataRicerca());
                for (int i = 0; i < lista.size(); i++) {
                    modeltabella.addRow(new Object[]{lista.get(i)});
                }
            }
        });

        btnIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framec.setVisible(true);
                frame.dispose();
            }
        });

        tabellaDimissioni.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Paziente"}){});
        DefaultTableModel modeltabella= (DefaultTableModel) tabellaDimissioni.getModel();
        ArrayList lista = controller.viewPazientiInDimissione(getDataRicerca());
        for (int i=0; i<lista.size(); i++){
            modeltabella.addRow(new Object[]{lista.get(i)});
        }
    }

    public JPanel getPanelDimissioni() {
        return panelDimissioni;
    }

    public LocalDate getDataRicerca() {
        return LocalDate.parse(textField1.getText());
    }

    public JTable getTabellaDimissioni() {
        return tabellaDimissioni;
    }
}