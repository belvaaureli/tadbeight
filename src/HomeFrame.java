import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {
        setTitle("B&A Academy");
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(245,235,221));

        //TITLE
        JLabel title = new JLabel("SISTEM LES B&A", SwingConstants.CENTER);
        title.setBounds(100,80,200,30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        //PENGAJAR (LOGIN)
        JButton btnPengajar = new JButton("Login Pengajar");
        btnPengajar.setBounds(100,220,200,40);
        btnPengajar.setBackground(new Color(168,198,108)); // ijo
        btnPengajar.setForeground(Color.WHITE);
        add(btnPengajar);

        //SISWA (TANPA LOGIN)
        JButton btnSiswa = new JButton("Masuk Siswa");
        btnSiswa.setBounds(100,280,200,40);
        btnSiswa.setBackground(new Color(216,138,166)); // pink
        btnSiswa.setForeground(Color.WHITE);
        add(btnSiswa);

        //PENGAJAR → KE LOGIN
        btnPengajar.addActionListener(e -> {
            new LoginPengajar().setVisible(true);
            dispose();
        });

        //SISWA → LANGSUNG DASHBOARD
        btnSiswa.addActionListener(e -> {
            new DashboardSiswa().setVisible(true);
            dispose();
        });
    }
}