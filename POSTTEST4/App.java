import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ArrayList<Kacamata> stockKacamata = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Kacamata> getStockKacamata() {
        return stockKacamata;
    }

    public void setStockKacamata(ArrayList<Kacamata> stockKacamata) {
        this.stockKacamata = stockKacamata;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        App fystics = new App();
        fystics.runApp();
    }

    public void runApp() {
        boolean appIsRunning = true;
        while (appIsRunning) {
            System.out.println("=== FYStics Optik ===");
            System.out.println("1. Tambah Stok Kacamata");
            System.out.println("2. Tampilkan Semua Stok Kacamata");
            System.out.println("3. Perbarui Stok Kacamata");
            System.out.println("4. Hapus Stok Kacamata");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1:
                    tambahStokKacamata();
                    break;
                case 2:
                    tampilkanSemuaStokKacamata();
                    break;
                case 3:
                    perbaruiStokKacamata();
                    break;
                case 4:
                    hapusStokKacamata();
                    break;
                case 5:
                    appIsRunning = false;
                    break;
                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }
        scanner.close();
    }

    private void tambahStokKacamata() {
        System.out.println("\nTambah Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata: ");
        String namaKacamata = scanner.nextLine();
        System.out.print("Masukkan harga kacamata: ");
        double hargaKacamata = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Pilih jenis kacamata:");
        System.out.println("1. Anak");
        System.out.println("2. Dewasa");
        System.out.println("3. Fashion");
        System.out.print("Pilih jenis kacamata: ");
        int jenisChoice = scanner.nextInt();
        scanner.nextLine();
        Kacamata kacamata;
        switch (jenisChoice) {
            case 1:
                kacamata = new KacamataAnak(namaKacamata, hargaKacamata);
                break;
            case 2:
                kacamata = new KacamataDewasa(namaKacamata, hargaKacamata);
                break;
            case 3:
                kacamata = new KacamataFashion(namaKacamata, hargaKacamata);
                break;
            default:
                System.out.println("Pilihan tidak valid. Kacamata akan ditambahkan sebagai kacamata umum.");
                kacamata = new Kacamata(namaKacamata, hargaKacamata);
                break;
        }
        stockKacamata.add(kacamata);
        System.out.println("Stok kacamata berhasil ditambahkan.");
    }

    private void tampilkanSemuaStokKacamata() {
        System.out.println("\nSemua Data Stok Kacamata di FYStics Optik:");
        if (stockKacamata.isEmpty()) {
            System.out.println("Stok kacamata kosong.");
        } else {
            for (int i = 0; i < stockKacamata.size(); i++) {
                Kacamata kacamata = stockKacamata.get(i);
                System.out.println((i+1) + ". " + kacamata.getNamaKacamata() + " (Rp" + kacamata.getHargaKacamata() + ")");
            }
        }
    }

    private void perbaruiStokKacamata() {
        System.out.println("\nPerbarui Data Stok Kacamata");
        System.out.print("Masukkan nomor urutan kacamata yang akan diperbarui: ");
        int nomorUrutan = scanner.nextInt();
        scanner.nextLine(); 

        if (nomorUrutan > 0 && nomorUrutan <= stockKacamata.size()) {
            int index = nomorUrutan - 1; 
            Kacamata kacamata = stockKacamata.get(index);

            System.out.println("Data Kacamata:");
            System.out.println("Nama: " + kacamata.getNamaKacamata());
            System.out.println("Harga: " + kacamata.getHargaKacamata());

            System.out.print("Masukkan nama kacamata baru: ");
            String newKacamata = scanner.nextLine();
            System.out.print("Masukkan harga kacamata baru: ");
            double newHarga = scanner.nextDouble();
            scanner.nextLine(); 

            kacamata.setNamaKacamata(newKacamata);
            kacamata.setHargaKacamata(newHarga);
            System.out.println("Data stok kacamata dengan nomor urutan " + nomorUrutan + " berhasil diperbarui.");
        } else {
            System.out.println("Nomor urutan kacamata tidak valid.");
        }
    }

    private void hapusStokKacamata() {
        System.out.println("\nHapus Data Stok Kacamata");
        tampilkanSemuaStokKacamata(); 
        System.out.print("Masukkan nomor urutan kacamata yang akan dihapus: ");
        int nomorUrutan = scanner.nextInt();
        scanner.nextLine(); 
        
        if (nomorUrutan > 0 && nomorUrutan <= stockKacamata.size()) {
            int index = nomorUrutan - 1; 
            Kacamata kacamata = stockKacamata.get(index);
            stockKacamata.remove(index); 
            
            System.out.println("Data stok kacamata dengan nomor urutan " + nomorUrutan + " berhasil dihapus:");
            System.out.println("Nama: " + kacamata.getNamaKacamata());
            System.out.println("Harga: " + kacamata.getHargaKacamata());
        } else {
            System.out.println("Nomor urutan kacamata tidak valid.");
        }
    }

    static class Kacamata {
        private String namaKacamata;
        private double hargaKacamata;

        public Kacamata(String namaKacamata, double hargaKacamata) {
            this.namaKacamata = namaKacamata;
            this.hargaKacamata = hargaKacamata;
        }

        public String getNamaKacamata() {
            return namaKacamata;
        }

        public void setNamaKacamata(String namaKacamata) {
            this.namaKacamata = namaKacamata;
        }

        public double getHargaKacamata() {
            return hargaKacamata;
        }

        public void setHargaKacamata(double hargaKacamata) {
            this.hargaKacamata = hargaKacamata;
        }
    }

    static class KacamataDewasa extends Kacamata {
        public KacamataDewasa(String namaKacamata, double hargaKacamata) {
            super(namaKacamata, hargaKacamata);
        }

        @Override
        public String getNamaKacamata() {
            return "Dewasa: " + super.getNamaKacamata();
        }
    }

    static class KacamataFashion extends KacamataDewasa {
        public KacamataFashion(String namaKacamata, double hargaKacamata) {
            super(namaKacamata, hargaKacamata);
        }

        @Override
        public double getHargaKacamata() {
            return super.getHargaKacamata();
        }
    }

    public static class KacamataAnak extends Kacamata {
        public KacamataAnak(String namaKacamata, double hargaKacamata) {
            super(namaKacamata, hargaKacamata);
        }

        public void setNamaKacamata(String namaKacamata, int umur) {
            if (umur < 12) {
                super.setNamaKacamata("Anak-anak: " + namaKacamata);
            } else {
                super.setNamaKacamata(namaKacamata);
            }
        }
    }
}
