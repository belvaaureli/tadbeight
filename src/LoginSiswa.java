import javax.swing.*;
import java.awt.*;

public class LoginSiswa extends JFrame {

    public LoginSiswa() {
        setTitle("Login Siswa");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JTextField txtId = new JTextField();
        txtId.setBounds(100, 100, 200, 30);
        add(txtId);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 160, 150, 35);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String id = txtId.getText();

            if (Koneksi.cekSiswa(id)) {
                new DashboardSiswa().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "ID tidak ditemukan!");
            }
        });
    }
}