package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
                DefaultTableModel modelLetti= (DefaultTableModel) tabellaLetti.getModel();
                ArrayList<String> lista=controller.parseLetti(controller.viewLetti(getCBvalue()));
                String red="\\u001B[31m";
                String green="\\u001B[32m";

                for(int i=0;i<lista.size();i++){
                    if(controller.checkAvailability(controller.cercaLetto(lista.get(i),getCBvalue()))){
                        modelLetti.addRow(new Object[]{lista.get(i)+green});
                    }
                    else{
                        modelLetti.addRow(new Object[]{lista.get(i)+red});
                    }
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
        for(int i=0;i<controller.getAmministratore().getreparti().size();i++){
            comboReparti.addItem(controller.getAmministratore().getreparti().get(i).getNome());
        }
        tabellaLetti.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Letti"}){});
    }

    public JPanel getPanelStatoLetti() {
        return panelStatoLetti;
    }

    public JComboBox getComboReparti() {
        return comboReparti;
    }
    public String getCBvalue(){
        return comboReparti.getSelectedItem().toString();
    }

    public JTable getTabellaLetti() {
        return tabellaLetti;
    }
}