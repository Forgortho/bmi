# Kalkulator BMI (JavaFX)

Sistem untuk menghitung BMI (Body Mass Index) dan kategorinya,
dibuat dengan Java, JavaFX, dan Maven di Apache NetBeans.

## Cara Menjalankan

1. Install JDK 21 atau lebih baru dan Apache NetBeans.
2. Download project ini: klik tombol hijau "Code" lalu "Download ZIP", kemudian ekstrak.
3. Di NetBeans, pilih File > Open Project, lalu pilih folder hasil ekstrak.
4. Tunggu sampai Maven selesai mengunduh dependency (butuh internet).
5. Klik kanan project, pilih Clean and Build, lalu Run.
   Class utama: bmi.Launcher

## Cara Memakai

1. Pilih jenis kelamin.
2. Isi tinggi (cm) dan berat (kg).
3. Klik Hitung untuk melihat nilai BMI dan kategorinya.
4. Klik Hapus untuk mengosongkan isian.

Batas input yang diterima: tinggi 100 - 250 cm dan berat 20 - 300 kg.
Jika input kosong, bukan angka, atau di luar rentang, pesan kesalahan akan tampil.

## Rumus dan Kategori

BMI = berat (kg) / tinggi (m)²

Kategori mengikuti batas WHO Asia-Pasifik:

| BMI          | Kategori            |
|--------------|---------------------|
| < 18,5       | Berat badan kurang  |
| 18,5 - 22,9  | Normal              |
| 23,0 - 24,9  | Berlebih            |
| 25,0 - 29,9  | Obesitas I          |
| ≥ 30,0       | Obesitas II         |

## Screenshot
<img width="333" height="385" alt="Screenshot 2026-11-02 094837" src="https://github.com/user-attachments/assets/33a786a8-aba6-4b15-a3b1-e5efca7ba9c9" />
<img width="332" height="387" alt="Screenshot 2026-11-02 094858" src="https://github.com/user-attachments/assets/b4a888d3-bba3-4df9-a97e-1623f0930435" />


![Tampilan hasil](tampilan-hasil.png)

## Teknologi

Java, JavaFX, FXML, Maven
