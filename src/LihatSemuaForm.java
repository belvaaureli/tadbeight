import javax.swing.*;
import java.sql.*;

public class LihatSemuaForm extends JFrame {

    JTextArea area;

    public LihatSemuaForm() {
        setTitle("Semua Data");
        setSize(500,400);
        setLocationRelativeTo(null);

        area = new JTextArea();
        add(new JScrollPane(area));

        tampilData();
    }

    void tampilData() {
        try {
            Connection c = Koneksi.getConnection();
            Statement st = c.createStatement();

            area.append("--- DATA SISWA ---\n");
            ResultSet rs1 = st.executeQuery("SELECT * FROM siswa");

            while(rs1.next()){
                area.append(
                    rs1.getString("id_siswa") + " - " +
                    rs1.getString("nama_siswa") + "\n"
                );
            }

            area.append("\n--- DATA JADWAL ---\n");
            ResultSet rs2 = st.executeQuery(
                "SELECT j.hari, j.jam, p.nama_pengajar, r.nama_ruangan " +
                "FROM jadwal j " +
                "JOIN pengajar p ON j.id_pengajar = p.id_pengajar " +
                "JOIN ruangan r ON j.id_ruangan = r.id_ruangan"
            );

            while(rs2.next()){
                area.append(
                    rs2.getString("hari") + " | " +
                    rs2.getString("jam") + " | " +
                    rs2.getString("nama_pengajar") + " | " +
                    rs2.getString("nama_ruangan") + "\n"
                );
            }

            area.append("\n--- DATA KEHADIRAN ---\n");
            ResultSet rs3 = st.executeQuery("SELECT * FROM kehadiran");

            while(rs3.next()){
                area.append(
                    rs3.getInt("id_kehadiran") + " | " +
                    rs3.getString("tanggal") + " | " +
                    rs3.getString("status") + "\n"
                );
            }

            area.append("\n--- AGREGAT ---\n");
            ResultSet ra = st.executeQuery("SELECT COUNT(*) AS total FROM siswa");

            if(ra.next()){
                area.append("Total siswa: " + ra.getInt("total") + "\n");
            }

            area.append("\n--- SUBQUERY ---\n");
            try {
                ResultSet rsq = st.executeQuery(
                    "SELECT * FROM siswa WHERE id_siswa IN (SELECT id_siswa FROM peserta)"
                );

                while(rsq.next()){
                    area.append(rsq.getString("nama_siswa") + "\n");
                }

            } catch(Exception e){
                area.append("Subquery tidak tersedia\n");
            }

            area.append("\n--- VIEW ---\n");
            try {
                ResultSet rv = st.executeQuery("SELECT * FROM view_siswa");

                while(rv.next()){
                    area.append(rv.getString("nama_siswa") + "\n");
                }

            } catch(Exception e){
                area.append("View belum dibuat\n");
            }

            area.append("\n--- PROCEDURE ---\n");
            try {
                CallableStatement cs = c.prepareCall("CALL getSiswa()");
                ResultSet rp = cs.executeQuery();

                while(rp.next()){
                    area.append(rp.getString("nama_siswa") + "\n");
                }

            } catch(Exception e){
                area.append("Procedure belum dibuat\n");
            }

            area.append("\n--- TRANSACTION ---\n");

            try {
                c.setAutoCommit(false);

                PreparedStatement pst = c.prepareStatement("SELECT COUNT(*) FROM siswa");
                ResultSet rt = pst.executeQuery();

                if(rt.next()){
                    area.append("Jumlah siswa dicek: " + rt.getInt(1) + "\n");
                }

                c.commit();
                area.append("Transaction berhasil (tanpa perubahan data)\n");

            } catch(Exception ex){
                try {
                    c.rollback();
                } catch(Exception e){}

                area.append("Transaction gagal\n");
            }

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}