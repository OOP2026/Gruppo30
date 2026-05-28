package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaEsito {
    private JPanel panelModificaEsito;
    private JLabel labelPaziente;
    private JTextArea areaEsito;
    private JTextArea areaPrestazioni;
    private JButton salvaButton;
    private JButton annullaButton;
    private JFrame frame;

    public ModificaEsito(JFrame framec, Controller controller) {
        frame= new JFrame("Modifica Esito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(framec);
        frame.pack();
        frame.setContentPane(getPanelModificaEsito());
        frame.setVisible(true);

        salvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.completaPrestazione(getPrestazioni(), getEsito());
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

    public JPanel getPanelModificaEsito() {
        return panelModificaEsito;
    }

    public void setLabelPaziente(String nomeCognome) {
        labelPaziente.setText(nomeCognome);
    }

    public String getEsito() {
        return areaEsito.getText();
    }

    public String getPrestazioni() {
        return areaPrestazioni.getText();
    }
}