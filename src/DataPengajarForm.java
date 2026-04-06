import javax.swing.*;
import java.awt.*;

public class DataPengajarForm extends JFrame {

    JTextField txtNama, txtHp;

    public DataPengajarForm() {
        setTitle("Tambah Pengajar");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        // JUDUL
        JLabel title = new JLabel("FORM INPUT PENGAJAR", SwingConstants.CENTER);
        title.setBounds(100,20,200,30);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        add(title);

        // NAMA
        JLabel lblNama = new JLabel("Nama:");
        lblNama.setBounds(50,80,100,25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(150,80,180,25);
        add(txtNama);

        // NO HP
        JLabel lblHp = new JLabel("No HP:");
        lblHp.setBounds(50,120,100,25);
        add(lblHp);

        txtHp = new JTextField();
        txtHp.setBounds(150,120,180,25);
        add(txtHp);

        // BUTTON
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(130,180,140,40);
        btnSimpan.setBackground(new Color(168,198,108));
        btnSimpan.setForeground(Color.WHITE);
        add(btnSimpan);

        // AKSI
        btnSimpan.addActionListener(e -> {
            Koneksi.simpanPengajar(
                txtNama.getText(),
                txtHp.getText()
            );

            JOptionPane.showMessageDialog(null, "Pengajar berhasil ditambahkan!");

            txtNama.setText("");
            txtHp.setText("");
        });
    }
}