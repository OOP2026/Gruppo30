package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;

public class AgendaMedico {
    private JPanel panelAgenda;
    private JButton btnAggiorna;
    private JTable tabellaAgenda;
    private JButton btnLogOut;
    private JTextField textField1;
    private JLabel campoDataAgenda;
    private JButton buttonPrestazione;
    private JButton buttonEsito;
    private JFrame frame;

    public AgendaMedico(JFrame framec, Controller controller) {
        frame = new JFrame("Agenda Medico");
        frame.setContentPane(getPanelAgenda());
        frame.pack();
        frame.setLocationRelativeTo(framec);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAggiorna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelAgenda = (DefaultTableModel) tabellaAgenda.getModel();
                ArrayList lista=controller.cercaPrestazioni(getDataSelezionata());
                for (int i=0; i<lista.size(); i++){
                    modelAgenda.addRow(new Object[]{lista.get(i)});
                }
            }
        });

        buttonEsito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaEsito modificaEsito = new ModificaEsito(frame, controller);
                frame.setVisible(false);
            }
        });

        buttonPrestazione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistraPrestazione registraPrestazione= new RegistraPrestazione(frame, controller);
                frame.setVisible(false);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framec.setVisible(true);
                frame.dispose();
            }
        });
        tabellaAgenda.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Prestazioni"}));
    }

    public JPanel getPanelAgenda() {
        return panelAgenda;
    }

    public LocalDate getDataSelezionata() {
        return LocalDate.parse(textField1.getText());
    }

    public JTable getTabellaAgenda() {
        return tabellaAgenda;
    }
}