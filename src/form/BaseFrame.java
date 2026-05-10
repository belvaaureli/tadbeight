package form;

public class BaseFrame extends javax.swing.JFrame {

    public void centerWindow() {
        setLocationRelativeTo(null);
    }

    //BIAR BISA OVERRIDE
    public void tampilRole() {
        System.out.println("Default Role");
    }
}