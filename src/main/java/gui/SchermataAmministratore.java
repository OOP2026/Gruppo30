package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;

public class SchermataAmministratore {
    private JButton gestionePazientiButton;
    private JButton gestioneRicoveriButton;
    private JButton ricercaDimissioniButton;
    private JButton statoLettiButton;
    private JPanel PanelAdmin;
    JFrame frame;


    public SchermataAmministratore(JFrame frameC, Controller controller) {
        frame= new JFrame("Area Amministratore");
        frame.setContentPane(PanelAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameC);
        frame.setVisible(true);

        gestionePazientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Gestione Pazienti");
                GestionePazienti gestionepazienti=new GestionePazienti(frame, controller);
                frame.setVisible(false);
            }
        });

        gestioneRicoveriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Gestione Ricoveri");
                //controller
            }
        });

        ricercaDimissioniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Ricerca Dimissioni");
                //controller
            }
        });

        statoLettiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log: Richiesta apertura Stato Letti");
                //controller
            }
        });
    }

    public JPanel getPanelAdmin() {
        return PanelAdmin;
    }
}