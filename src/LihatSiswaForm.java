import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LihatSiswaForm extends JFrame {

    JTextArea area;

    public LihatSiswaForm() {
        setTitle("Data Siswa");
        setSize(400,400);
        setLocationRelativeTo(null);

        area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        add(scroll);

        tampil();
    }

    void tampil() {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM siswa";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            area.setText(""); // reset

            while (rs.next()) {
                String data =
                    rs.getString("id_siswa") + " | " +
                    rs.getString("nama_siswa") + " | " +
                    rs.getString("no_hp") + " | " +
                    rs.getString("alamat");

                area.append(data + "\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}