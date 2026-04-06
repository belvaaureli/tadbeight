public class Model {

    //ENKAPSULASI
    static class Siswa {
        private String nama;

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNama() {
            return nama;
        }
    }

    //INHERITANCE
    static class User {
        String nama;
    }

    static class Pengajar extends User {
        String mapel;
    }

    //POLYMORPHISM
    static class Cetak {
        void tampil() {
            System.out.println("Menampilkan data umum");
        }
    }

    static class CetakSiswa extends Cetak {
        @Override
        void tampil() {
            System.out.println("Menampilkan data siswa");
        }
    }

    //ABSTRACT CLASS
    static abstract class Data {
        abstract void tampil();
    }

    static class DataSiswa extends Data {
        void tampil() {
            System.out.println("Data siswa ditampilkan");
        }
    }

    //INTERFACE
    interface Aksi {
        void jalan();
    }

    static class AksiSiswa implements Aksi {
        public void jalan() {
            System.out.println("Aksi siswa berjalan");
        }
    }
}