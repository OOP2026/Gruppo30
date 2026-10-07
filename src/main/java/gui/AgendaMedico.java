package gui;

import controller.Controller;
import javax.swing.*;

public class AgendaMedico {
    private JFrame frame;
    private JPanel panelAgenda;
    private JButton btnAggiorna;
    private JTable tabellaAgenda;
    private JButton btnLogOut;
    private JButton btnEffettuaVisita;
    private JTextField agendaText;
    private JLabel campoDataAgenda;
    private JLabel agendaLabel;
    private JButton btnModificaEsito;

    public AgendaMedico(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Sistema Ospedaliero - Agenda Medico");
        frame.setContentPane(panelAgenda);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public String getDataSelezionata() {
        if (agendaText != null) {
            return agendaText.getText().trim();
        } else {
            return "";
        }
    }

    public void svuotaCampi() {
        if (agendaText != null) {
            agendaText.setText("");
        }
    }

    public JButton getBtnModificaEsito() {
        return btnModificaEsito;
    }

    public JButton getBtnAggiorna() {
        return btnAggiorna;
    }

    public JButton getBtnLogOut() {
        return btnLogOut;
    }

    public JButton getBtnEffettuaVisita() {
        return btnEffettuaVisita;
    }

    public JTable getTabellaAgenda() {
        return tabellaAgenda;
    }

    public JPanel getPanelAgenda() {
        return panelAgenda;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void mostraMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(frame, messaggio, "Informazione", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraErrore(String messaggio) {
        JOptionPane.showMessageDialog(frame, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void visualizza(boolean visibile) {
        frame.setVisible(visibile);
    }
}