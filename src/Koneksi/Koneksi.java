package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/dbeight_ta";
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("Koneksi berhasil");

        } catch (Exception e) {

            System.out.println("Koneksi gagal : " + e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }
}