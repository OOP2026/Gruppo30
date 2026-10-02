package gui;

import controller.Controller;

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
    private static JFrame frame;
    private final Controller controller=new Controller();

    private JCheckBox chkAdmin;
    private JCheckBox chkMedico;

    public Login() {
        accediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField1.getText();
                String pass = new String(passwordField1.getPassword());
                if(isTestAdmin()){
                    controller.login(user,pass,true);
                    SchermataAmministratore schermataAmministratore=new SchermataAmministratore(frame, controller);
                    frame.setVisible(false);
                } else if (isTestMedico()) {
                    controller.login(user,pass,false);
                    AgendaMedico agendaMedico=new AgendaMedico(frame, controller);
                    frame.setVisible(false);
                }

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
        frame = new JFrame("Sistema Ospedaliero - Accesso");
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