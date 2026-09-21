# 🎮 Sistem Rental Console Game (PlayStation Lounge)

Proyek ini adalah implementasi sistem manajemen transaksi penyewaan konsol game (PlayStation 4 dan PlayStation 5) berbasis *Command Line Interface* (CLI) menggunakan bahasa pemrograman Java. Aplikasi ini dirancang sebagai pemenuhan tugas mata kuliah Pemrograman Berorientasi Objek (PBO), dengan menerapkan arsitektur MVC (*Model-View-Controller*).

## 🚀 Deskripsi Sistem
Aplikasi ini memungkinkan pengelola rental untuk mencatat transaksi sewa unit konsol berdasarkan durasi waktu, serta menangani penambahan biaya khusus (seperti penambahan stik ekstra untuk PS4 atau akses ke layanan game VIP untuk PS5). Sistem secara otomatis akan mengkalkulasi total biaya sewa dari masing-masing pelanggan.

### Fitur Utama:
- **Tampilkan Data (Read):** Menampilkan log transaksi aktif dalam format tabel terminal yang rapi.
- **Tambah Sewa (Create):** Menginput penyewa baru untuk PS4 maupun PS5 dengan mekanisme perhitungan biaya yang terpisah.
- **Perpanjang Sewa (Update):** Memperbarui atau menambah durasi jam pada transaksi yang sedang berjalan berdasarkan ID.
- **Selesaikan Sewa (Delete):** Menghapus data pelanggan dari daftar aktif jika masa sewanya telah selesai.
- **Validasi *Error*:** Dilengkapi dengan blok `try-catch` (`NumberFormatException`) untuk mencegah *crash* saat terjadi kesalahan input pengguna (misal: memasukkan teks pada form angka).

## 🧩 Implementasi Konsep PBO
Sistem ini memenuhi seluruh kriteria dasar pemrograman berorientasi objek:
1. **Encapsulation:** Perlindungan variabel (`private`) pada kelas model, dikelola menggunakan `Getter` dan `Setter`.
2. **Inheritance (Pewarisan):** 
   - `SewaConsole` (Superclass): Menyimpan entitas dasar seperti ID, Nama, Durasi, dan Tarif Dasar.
   - `SewaPS4` & `SewaPS5` (Subclass): Mewarisi atribut dasar dan menambahkan properti spesifik masing-masing.
3. **Polymorphism:** Metode `hitungTotalBiaya()` dan `tampilkanDetail()` di-*override* untuk membedakan kalkulasi biaya dan format cetak spesifikasi tiap tipe konsol.
4. **Collection:** Penggunaan `ArrayList` untuk menampung dan memanipulasi *dummy data* awal secara dinamis.

## 📂 Struktur MVC (Packages)
Pemisahan logika bisnis dan tampilan antarmuka:
- `Controller/RentalController.java`: Pusat kendali, menampung logika array, CRUD, dan validasi data.
- `Model/`: Berisi cetak biru objek (`SewaConsole.java`, `SewaPS4.java`, `SewaPS5.java`).
- `View/ConsoleView.java`: Mengatur interaksi pengguna, menu, dan input/output CLI.
- `Main.java`: Berfungsi sebagai titik awal (Entry Point) eksekusi program.

---
**Author:**  
Mukhammad Ismul Azam Atmoko  
*Mahasiswa Fakultas Teknik, Program Studi Sistem Informasi*
