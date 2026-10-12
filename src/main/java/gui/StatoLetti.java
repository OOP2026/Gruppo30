package gui;

import controller.Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

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
        //Codice rosso per i letti occupati:
        tabellaLetti.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int col) {   //Sovrascrive il metodo che Swing esegue automaticamente per ogni singola cella visibile a monitor.
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); //restituisce una JLabel già preconfigurata con il testo, i margini interni e lo sfondo standard di Swing.

                Object stato = table.getValueAt(row, 3);
                if (col == 0 && stato != null && stato.toString().equalsIgnoreCase("Occupato")) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }

                return c;
            }
        });
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