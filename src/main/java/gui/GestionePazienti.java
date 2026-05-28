package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;
import java.time.LocalDate;

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
    private JButton ritornaButton;
    private JFrame frame;

    public GestionePazienti(JFrame framec, Controller controller) {
        frame = new JFrame("Gestione Pazienti");
        frame.setContentPane(getPanelPazienti());
        frame.setLocationRelativeTo(framec);
        frame.pack();
        frame.setVisible(true);

        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.aggiungiPaziente(getNome(),getCognome(),getCodiceFiscale(),getDataNascita());
            }
        });

        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                svuotaCampi();
            }
        });

        ritornaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                framec.setVisible(true);
                frame.dispose();
            }
        });
    }

    public JPanel getPanelPazienti() {
        return panelPazienti;
    }

    public String getNome() { return textField1.getText(); }
    public String getCognome() { return textField2.getText(); }
    public String getCodiceFiscale() { return textField3.getText(); }
    public LocalDate getDataNascita() { return LocalDate.parse(textField4.getText()); }

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