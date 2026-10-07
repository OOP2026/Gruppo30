package gui;

import javax.swing.*;

public class Login {
    private JFrame frame;
    private JPanel login;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton accediButton;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JCheckBox chkAdmin;
    private JCheckBox chkMedico;
    private JLabel sistemaLabel;

    public Login() {
        frame = new JFrame("Sistema Ospedaliero - Accesso");
        frame.setContentPane(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
    }
    public String getUsername() {
        return userField.getText().trim();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public boolean isAdminSelected() {
        if (chkAdmin != null && chkAdmin.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMedicoSelected() {
        if (chkMedico != null && chkMedico.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public JButton getAccediButton() {
        return accediButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void mostraErrore(String messaggio) {
        JOptionPane.showMessageDialog(frame, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void visualizza(boolean visibile) {
        frame.setVisible(visibile);
    }
}