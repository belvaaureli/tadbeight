package form;

public abstract class UserAbstract {

    protected String nama;

    public UserAbstract(String nama) {
        this.nama = nama;
    }

    // 🔥 abstract method (WAJIB di override)
    public abstract void tampilUser();
}