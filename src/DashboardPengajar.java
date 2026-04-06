import javax.swing.*;
import java.awt.*;

public class DashboardPengajar extends JFrame {

    public DashboardPengajar() {
        setTitle("Dashboard Pengajar");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1,15,15)); //dari 6 jadi 7
        panel.setBackground(new Color(245,235,221));
        panel.setBorder(BorderFactory.createEmptyBorder(50,100,50,100));

        JLabel title = new JLabel("DASHBOARD PENGAJAR", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        //BUTTON
        JButton btnSiswa = new JButton("Data Siswa");
        JButton btnPengajar = new JButton("Tambah Pengajar"); //INI YANG KAMU MAU
        JButton btnJadwal = new JButton("Jadwal");
        JButton btnKehadiran = new JButton("Kehadiran");
        JButton btnRuangan = new JButton("Ruangan");
        JButton btnLihat = new JButton("Lihat Semua Data");
        JButton btnLogout = new JButton("Logout");

        //WARNA
        Color hijau = new Color(168,198,108);
        Color pink = new Color(216,138,166);

        btnSiswa.setBackground(hijau);
        btnPengajar.setBackground(pink); //beda biar keliatan
        btnJadwal.setBackground(pink);
        btnKehadiran.setBackground(hijau);
        btnRuangan.setBackground(pink);
        btnLihat.setBackground(pink);
        btnLogout.setBackground(hijau);

        btnSiswa.setForeground(Color.WHITE);
        btnPengajar.setForeground(Color.WHITE);
        btnJadwal.setForeground(Color.WHITE);
        btnKehadiran.setForeground(Color.WHITE);
        btnRuangan.setForeground(Color.WHITE);
        btnLihat.setForeground(Color.WHITE);
        btnLogout.setForeground(Color.WHITE);

        //MASUKIN KE PANEL (URUTAN)
        panel.add(btnSiswa);
        panel.add(btnPengajar); //MASUKIN DI SINI
        panel.add(btnJadwal);
        panel.add(btnKehadiran);
        panel.add(btnRuangan);
        panel.add(btnLihat);
        panel.add(btnLogout);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        //AKSI
        btnSiswa.addActionListener(e -> new DataSiswaForm().setVisible(true));
        btnPengajar.addActionListener(e -> new DataPengajarForm().setVisible(true)); //INI KUNCINYA
        btnJadwal.addActionListener(e -> new JadwalForm().setVisible(true));
        btnKehadiran.addActionListener(e -> new KehadiranForm().setVisible(true));
        btnRuangan.addActionListener(e -> new RuanganForm().setVisible(true));
        btnLihat.addActionListener(e -> new LihatSemuaForm().setVisible(true));

        btnLogout.addActionListener(e -> {
            dispose();
            new HomeFrame().setVisible(true);
        });
    }
}