import javax.swing.*;
import java.awt.*;

public class RuanganForm extends JFrame {

    JTextField txtNama, txtKapasitas;

    public RuanganForm() {
        setTitle("Tambah Ruangan");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("FORM INPUT RUANGAN");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(80,20,250,30);
        add(title);

        //NAMA RUANGAN
        JLabel l1 = new JLabel("Nama:");
        l1.setBounds(50,80,100,25);
        add(l1);

        txtNama = new JTextField();
        txtNama.setBounds(150,80,150,25);
        add(txtNama);

        //KAPASITAS
        JLabel l2 = new JLabel("Kapasitas:");
        l2.setBounds(50,120,100,25);
        add(l2);

        txtKapasitas = new JTextField();
        txtKapasitas.setBounds(150,120,150,25);
        add(txtKapasitas);

        //BUTTON SIMPAN
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(130,170,120,35);

        btnSimpan.setBackground(new Color(168,198,108));
        btnSimpan.setForeground(Color.WHITE);

        add(btnSimpan);

        //AKSI SIMPAN
        btnSimpan.addActionListener(e -> {
            try {
                String nama = txtNama.getText();
                int kapasitas = Integer.parseInt(txtKapasitas.getText());

                Koneksi.simpanRuangan(nama, kapasitas);

                JOptionPane.showMessageDialog(null, "Berhasil ditambah");

                txtNama.setText("");
                txtKapasitas.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Input salah!");
            }
        });
    }
}