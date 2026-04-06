import java.sql.*;

public class Koneksi {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/dbeight_TA";
            String user = "root";
            String pass = "";

            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }

    public static void simpanSiswa(String nama, String noHp, String alamat) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO siswa(nama_siswa, no_hp, alamat) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nama);
            pst.setString(2, noHp);
            pst.setString(3, alamat);

            pst.executeUpdate();
            System.out.println("Siswa berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void simpanPengajar(String nama, String noHp) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO pengajar(nama_pengajar, no_hp) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nama);
            pst.setString(2, noHp);

            pst.executeUpdate();
            System.out.println("Pengajar berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void simpanRuangan(String nama, int kapasitas) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO ruangan(nama_ruangan, kapasitas) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nama);
            pst.setInt(2, kapasitas);

            pst.executeUpdate();
            System.out.println("Ruangan ditambahkan!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void simpanJadwal(String hari, String jam, int idPengajar, int idRuangan) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO jadwal(hari, jam, id_pengajar, id_ruangan) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, hari);
            pst.setString(2, jam);
            pst.setInt(3, idPengajar);
            pst.setInt(4, idRuangan);

            pst.executeUpdate();
            System.out.println("Jadwal dibuat!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void simpanPeserta(int idSiswa, int idJadwal) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO peserta(id_siswa, id_jadwal) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idSiswa);
            pst.setInt(2, idJadwal);

            pst.executeUpdate();
            System.out.println("Peserta ditambahkan!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void simpanKehadiran(int idPeserta, String tanggal, String status) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO kehadiran(id_peserta, tanggal, status) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idPeserta);
            pst.setString(2, tanggal);
            pst.setString(3, status);

            pst.executeUpdate();
            System.out.println("Kehadiran dicatat!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static boolean cekSiswa(String id) {
    try {
        Connection conn = getConnection();
        String sql = "SELECT * FROM siswa WHERE id_siswa = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();

        return rs.next(); // true kalau ketemu

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static ResultSet getRuangan() {
    try {
        Connection c = getConnection();
        String sql = "SELECT * FROM ruangan";
        Statement st = c.createStatement();
        return st.executeQuery(sql);
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
}
}