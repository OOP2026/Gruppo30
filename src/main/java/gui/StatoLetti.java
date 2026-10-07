package gui;

import controller.Controller;
import javax.swing.*;

public class StatoLetti {
    private JFrame frame;
    private JPanel panelStatoLetti;
    private JButton cercaBtn;
    private JTable tabellaLetti;
    private JComboBox<String> comboReparti;
    private JButton btnIndietro;

    public StatoLetti(JFrame parentFrame, Controller controller) {
        frame = new JFrame("Monitoraggio Stato Letti");
        frame.setContentPane(panelStatoLetti);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(parentFrame);
    }

    public String getRepartoSelezionato() {
        if (comboReparti != null && comboReparti.getSelectedItem() != null) {
            return comboReparti.getSelectedItem().toString().trim();
        }
        else {
            return "";
        }
    }

    public JComboBox<String> getComboReparti() {
        return comboReparti;
    }
    
    public JButton getCercaBtn() {
        return cercaBtn;
    }

    public JButton getBtnIndietro() {
        return btnIndietro;
    }

    public JTable getTabellaLetti() {
        return tabellaLetti;
    }

    public JPanel getPanelStatoLetti() {
        return panelStatoLetti;
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
    public void popolaReparti(java.util.List<String> reparti) {
        if (comboReparti != null) {
            comboReparti.removeAllItems();
            for (String rep : reparti) {
                comboReparti.addItem(rep);
            }
        }
    }
}