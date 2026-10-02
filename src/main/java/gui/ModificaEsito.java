package gui;

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

    public ModificaEsito() {
        salvaButton.addActionListener(new ActionListener() {
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