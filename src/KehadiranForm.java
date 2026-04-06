import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class KehadiranForm extends JFrame {

    JTextField txtTanggal, txtStatus, txtIdSiswa;
    JButton btnTambah;

    public KehadiranForm() {
        setTitle("Form Kehadiran");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        // LABEL
        JLabel lblTanggal = new JLabel("Tanggal:");
        lblTanggal.setBounds(50,50,100,25);
        add(lblTanggal);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(50,90,100,25);
        add(lblStatus);

        JLabel lblIdSiswa = new JLabel("ID Siswa:");
        lblIdSiswa.setBounds(50,130,100,25);
        add(lblIdSiswa);

        // TEXTFIELD
        txtTanggal = new JTextField();
        txtTanggal.setBounds(150,50,150,25);
        add(txtTanggal);

        txtStatus = new JTextField();
        txtStatus.setBounds(150,90,150,25);
        add(txtStatus);

        txtIdSiswa = new JTextField();
        txtIdSiswa.setBounds(150,130,150,25);
        add(txtIdSiswa);

        // BUTTON
        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(130,180,120,35);
        btnTambah.setBackground(new Color(168,198,108));
        btnTambah.setForeground(Color.WHITE);
        add(btnTambah);

        //AKSI SIMPAN KE DATABASE
        btnTambah.addActionListener(e -> {
            try {
                Connection conn = Koneksi.getConnection();

                String sql = "INSERT INTO kehadiran (tanggal, status, id_siswa) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, txtTanggal.getText());
                pst.setString(2, txtStatus.getText());
                pst.setInt(3, Integer.parseInt(txtIdSiswa.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

                // reset form biar enak
                txtTanggal.setText("");
                txtStatus.setText("");
                txtIdSiswa.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}