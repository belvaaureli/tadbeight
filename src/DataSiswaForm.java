import javax.swing.*;
import java.awt.*;

public class DataSiswaForm extends JFrame {

    JTextField txtNama, txtHp, txtAlamat;

    public DataSiswaForm() {
        setTitle("Tambah Siswa");
        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(new Color(245,235,221));

        //JUDUL
        JLabel title = new JLabel("FORM INPUT SISWA", SwingConstants.CENTER);
        title.setBounds(80,20,240,30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        //LABEL + INPUT

        JLabel lblNama = new JLabel("Nama:");
        lblNama.setBounds(50,80,100,25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(150,80,180,25);
        add(txtNama);

        JLabel lblHp = new JLabel("No HP:");
        lblHp.setBounds(50,120,100,25);
        add(lblHp);

        txtHp = new JTextField();
        txtHp.setBounds(150,120,180,25);
        add(txtHp);

        JLabel lblAlamat = new JLabel("Alamat:");
        lblAlamat.setBounds(50,160,100,25);
        add(lblAlamat);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(150,160,180,25);
        add(txtAlamat);

        //BUTTON
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(130,230,140,40);
        btnSimpan.setBackground(new Color(168,198,108)); // ijo
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFocusPainted(false);
        add(btnSimpan);

        //AKSI SIMPAN
        btnSimpan.addActionListener(e -> {

            String nama = txtNama.getText();
            String hp = txtHp.getText();
            String alamat = txtAlamat.getText();

            if (nama.isEmpty() || hp.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                return;
            }

            Koneksi.simpanSiswa(nama, hp, alamat);

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");

            // reset
            txtNama.setText("");
            txtHp.setText("");
            txtAlamat.setText("");
        });
    }
}