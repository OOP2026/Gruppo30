package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton accediButton;
    private JLabel username;
    private JLabel password;

    private JCheckBox chkAdmin;
    private JCheckBox chkMedico;

    public Login() {
        accediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField1.getText();
                String pass = new String(passwordField1.getPassword());

                //controller
                //Se isTestAdmin() è true apri SchermataAmministratore.
                //Se isTestMedico() è true apri AgendaMedico.
            }
        });
    }

    public JPanel getLoginPanel() {
        return login;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Ospedaliero - Accesso");
        frame.setContentPane(new Login().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public boolean isTestAdmin() {
        return chkAdmin != null && chkAdmin.isSelected();
    }
    public boolean isTestMedico() {
        return chkMedico != null && chkMedico.isSelected();
    }
}