import javax.swing.*;
import java.awt.*;

public class LoginPengajar extends JFrame {

    public LoginPengajar() {
        setTitle("Login Pengajar");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("LOGIN PENGAJAR", SwingConstants.CENTER);
        title.setBounds(100, 30, 200, 30);
        add(title);

        JTextField txtPass = new JTextField();
        txtPass.setBounds(100, 100, 200, 30);
        add(txtPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 160, 150, 35);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String pass = txtPass.getText();

            if (pass.equals("admin123")) {
                new DashboardPengajar().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Password salah!");
            }
        });
    }
}