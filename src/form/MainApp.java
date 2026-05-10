package form;

import koneksi.Koneksi;
import java.sql.Connection;

public class MainApp {

    public static void main(String[] args) {

        Connection conn = Koneksi.getConnection();

        if (conn != null) {
            System.out.println("DATABASE CONNECTED");
        } else {
            System.out.println("DATABASE GAGAL");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new formlogin().setVisible(true);
        });
    }
}