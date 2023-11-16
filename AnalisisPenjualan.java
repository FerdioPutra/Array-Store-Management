import java.util.Scanner;

public class AnalisisPenjualan {
    public static void main(String[] args) {
        // Data penjualan setiap hari selama lima minggu
        int[][] penjualan = {
            {120, 150, 130, 200, 180},
            {100, 110, 120, 130, 140},
            {90, 95, 100, 110, 120},
            {80, 85, 90, 95, 100},
            {150, 160, 170, 180, 190},
            {70, 75, 80, 85, 90},
            {200, 210, 220, 230, 240}
        };

        // Array yang berisi Nama hari
        String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

        // Menghitung rata-rata per hari, rata-rata per minggu, dan total penjualan
        double[] rataPerHari = new double[7];
        double rataPerMinggu = 0;
        int totalPenjualan = 0;

        for (int hari = 0; hari < 7; hari++) {
            int totalHarian = 0;
            for (int minggu = 0; minggu < 5; minggu++) {
                totalHarian += penjualan[hari][minggu];
                totalPenjualan += penjualan[hari][minggu];
            }
            rataPerHari[hari] = totalHarian / 5.0;
            System.out.println("Rata-rata penjualan " + namaHari[hari] + ": " + rataPerHari[hari]);
        }

        rataPerMinggu = totalPenjualan / 35.0;
        System.out.println("\nRata-rata penjualan per minggu: " + rataPerMinggu);
        System.out.println("Total penjualan selama satu minggu: " + totalPenjualan);

        // Fitur pencarian data penjualan pada hari tertentu menggunakan linear search dengan input dari pengguna
        Scanner input = new Scanner(System.in);
        System.out.print("\nMasukkan nama hari untuk mencari data penjualan: ");
        String namaHariDicari = input.nextLine();

        int indeksHari = linearSearch(penjualan, namaHari, namaHariDicari);

        if (indeksHari != -1) {
            System.out.println("Data penjualan pada " + namaHariDicari + ":");
            for (int minggu = 0; minggu < 5; minggu++) {
                System.out.println("Minggu " + (minggu + 1) + ": " + penjualan[indeksHari][minggu]);
            }
        } else {
            System.out.println("Hari tidak ditemukan dalam data penjualan.");
        }

        input.close();
    }

    // Metode untuk mencari indeks hari menggunakan linear search
    public static int linearSearch(int[][] arr, String[] days, String day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equalsIgnoreCase(day)) {
                return i;
            }
        }
        return -1;
    }
}
