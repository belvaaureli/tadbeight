import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JadwalForm extends JFrame {

    JTextField txtHari, txtJam, txtPengajar, txtRuangan;

    public JadwalForm() {
        setTitle("Form Jadwal");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        // LABEL
        JLabel l1 = new JLabel("Hari:");
        l1.setBounds(50,50,100,25);
        add(l1);

        JLabel l2 = new JLabel("Jam:");
        l2.setBounds(50,90,100,25);
        add(l2);

        JLabel l3 = new JLabel("ID Pengajar:");
        l3.setBounds(50,130,100,25);
        add(l3);

        JLabel l4 = new JLabel("ID Ruangan:");
        l4.setBounds(50,170,100,25);
        add(l4);

        // TEXTFIELD
        txtHari = new JTextField();
        txtHari.setBounds(150,50,150,25);
        add(txtHari);

        txtJam = new JTextField();
        txtJam.setBounds(150,90,150,25);
        add(txtJam);

        txtPengajar = new JTextField();
        txtPengajar.setBounds(150,130,150,25);
        add(txtPengajar);

        txtRuangan = new JTextField();
        txtRuangan.setBounds(150,170,150,25);
        add(txtRuangan);

        // BUTTON
        JButton btnTambah = new JButton("Tambah");
        btnTambah.setBounds(130,210,120,35);
        btnTambah.setBackground(new Color(168,198,108));
        btnTambah.setForeground(Color.WHITE);
        add(btnTambah);

        // AKSI
        btnTambah.addActionListener(e -> {
            try {
                Connection conn = Koneksi.getConnection();

                String sql = "INSERT INTO jadwal (hari, jam, id_pengajar, id_ruangan) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, txtHari.getText());
                pst.setString(2, txtJam.getText());
                pst.setInt(3, Integer.parseInt(txtPengajar.getText()));
                pst.setInt(4, Integer.parseInt(txtRuangan.getText()));

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Jadwal berhasil ditambahkan!");

                // reset
                txtHari.setText("");
                txtJam.setText("");
                txtPengajar.setText("");
                txtRuangan.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}