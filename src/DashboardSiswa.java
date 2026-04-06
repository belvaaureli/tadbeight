import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DashboardSiswa extends JFrame {

    public DashboardSiswa() {
        setTitle("Dashboard Siswa");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //PANEL UTAMA
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245,235,221));

        //JUDUL ATAS (INI YANG KAMU MAU)
        JLabel title = new JLabel("DASHBOARD SISWA", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));

        mainPanel.add(title, BorderLayout.NORTH);

        //PANEL TOMBOL (TETEP SAMA)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,10,15));
        panel.setBackground(new Color(245,235,221));
        panel.setBorder(BorderFactory.createEmptyBorder(20,150,50,150));

        JButton btnData = new JButton("Data Siswa");
        JButton btnJadwal = new JButton("Jadwal");
        JButton btnKehadiran = new JButton("Kehadiran");
        JButton btnLogout = new JButton("Logout");

        btnData.setBackground(new Color(168,198,108));
        btnData.setForeground(Color.WHITE);

        btnJadwal.setBackground(new Color(216,138,166));
        btnJadwal.setForeground(Color.WHITE);

        btnKehadiran.setBackground(new Color(168,198,108));
        btnKehadiran.setForeground(Color.WHITE);

        btnLogout.setBackground(new Color(216,138,166));
        btnLogout.setForeground(Color.WHITE);

        panel.add(btnData);
        panel.add(btnJadwal);
        panel.add(btnKehadiran);
        panel.add(btnLogout);

        mainPanel.add(panel, BorderLayout.CENTER);

        add(mainPanel);

        //DATA SISWA
        btnData.addActionListener(e -> {
            try {
                Connection conn = Koneksi.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM siswa");

                JTextArea area = new JTextArea();
                area.setEditable(false);

                while (rs.next()) {
                    area.append(
                        rs.getInt("id_siswa") + " | " +
                        rs.getString("nama_siswa") + " | " +
                        rs.getString("no_hp") + " | " +
                        rs.getString("alamat") + "\n"
                    );
                }

                JOptionPane.showMessageDialog(null, new JScrollPane(area));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //JADWAL
        btnJadwal.addActionListener(e -> {
            try {
                Connection conn = Koneksi.getConnection();
                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery(
                    "SELECT j.id_jadwal, j.hari, j.jam, p.nama_pengajar, r.nama_ruangan " +
                    "FROM jadwal j " +
                    "JOIN pengajar p ON j.id_pengajar = p.id_pengajar " +
                    "JOIN ruangan r ON j.id_ruangan = r.id_ruangan"
                );

                JTextArea area = new JTextArea();
                area.setEditable(false);

                while (rs.next()) {
                    area.append(
                        rs.getInt("id_jadwal") + " | " +
                        rs.getString("hari") + " | " +
                        rs.getString("jam") + " | " +
                        rs.getString("nama_pengajar") + " | " +
                        rs.getString("nama_ruangan") + "\n"
                    );
                }

                JOptionPane.showMessageDialog(null, new JScrollPane(area));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //KEHADIRAN
        btnKehadiran.addActionListener(e -> {
            try {
                Connection conn = Koneksi.getConnection();
                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM kehadiran");

                JTextArea area = new JTextArea();
                area.setEditable(false);

                while (rs.next()) {
                    area.append(
                        rs.getInt("id_kehadiran") + " | " +
                        rs.getString("tanggal") + " | " +
                        rs.getString("status") + "\n"
                    );
                }

                JOptionPane.showMessageDialog(null, new JScrollPane(area));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        //LOGOUT
        btnLogout.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            dispose();
        });
    }
}