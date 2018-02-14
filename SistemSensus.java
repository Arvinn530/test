import java.util.Scanner;

public class SistemSensus {
	public static String generatorId(String nama, short panjang, short lebar, short tinggi) {
		int sum = 0;
		for(int ix = 0; ix < nama.length(); ix++) {
			sum += Character.getNumericValue(nama.charAt(ix));
		}
		return String.valueOf(nama.charAt(0)) + ((panjang * lebar * tinggi) + sum) % 10000;
	}

	public static void main(String args[]) {
		// Membuat objek sebagai input
		Scanner input = new Scanner(System.in);

		// Proses input data
		System.out.print("PROGRAM PENCETAK DATA SENSUS\n" +
				"--------------------\n" +
				"Nama Kepala Keluarga   : ");
		String nama = input.nextLine().replace(" ", "");
		System.out.print("Alamat Rumah           : ");
		String alamat = input.nextLine().replace(" ", "");
		System.out.print("Panjang Tubuh (cm)     : ");
		short panjang = Short.parseShort(input.nextLine().replace(" ", ""));
		System.out.print("Lebar Tubuh (cm)       : ");
		short lebar = Short.parseShort(input.nextLine().replace(" ", ""));
		System.out.print("Tinggi Tubuh (cm)      : ");
		short tinggi = Short.parseShort(input.nextLine().replace(" ", ""));
		System.out.print("Berat Tubuh (kg)       : ");
		float berat = Float.parseFloat(input.nextLine().replace(" ", ""));
		System.out.print("Jumlah Anggota Keluarga: ");
		short jumlahAnggota = Short.parseShort(input.nextLine().replace(" ", ""));
		System.out.print("Tanggal Lahir          : ");
		String tanggalLahir = input.nextLine().replace(" ", "");
		System.out.print("Catatan Tambahan       : ");
		String catatan = input.nextLine().replace(" ", "");
		System.out.print("Jumlah Cetakan Data    : ");
		short jumlahCetakan = Short.parseShort(input.nextLine().replace(" ", ""));

		// Memeriksa catatan kosong atau tidak
		if (catatan.isEmpty() ) catatan = "Tidak ada catatan tambahan";
		else catatan = "Catatan: " + catatan;

		// Mengkalkulasi rasio dengan data yang dimiliki
		float rasio = (float) (berat/ ((panjang * lebar * tinggi) * 0.000001));
		String tanggalLahirArr[] = tanggalLahir.split("-");

		//Mencetak data sang keluarga
		for (int ix = 1; ix <= jumlahCetakan; ix++) {
			// Scope untuk menampilkan data
			System.out.print("\nPencetakan " + ix + " dari " + jumlahCetakan + " untuk: ");
			String penerima = input.nextLine(); 
			System.out.println("DATA SIAP DICETAK UNTUK ARSIP " + penerima.toUpperCase());

			// Mencetak hasil
			String hasil = nama + " - " + alamat + "\nLahir pada tanggal " + tanggalLahirArr[0] + 
				" - " + tanggalLahirArr[1] + " - " + tanggalLahirArr[2] + "\nRasio Berat Per Volume %.0f"  + 
				" kg/m^3\n" + catatan + "\n";
			System.out.format(hasil, rasio);
		}

		// Mengecek apakah sang keluarga harus di beri pemberitahuan untuk relokasi tempat tinggal
		if ((0 < panjang) && (panjang < 250) && (0 < lebar) && (lebar < 250) &&
			(0 < tinggi) && (tinggi < 250) && (0 < berat) && (berat < 150) && 
			(0 < jumlahAnggota) && (jumlahAnggota < 20)) {

			//Menyiapkan data berupa nomor keluarga, anggaran, umur, dsb
			String nomorKeluarga = generatorId(nama, panjang, lebar, tinggi);
			int anggaran = 50000 * 365 * jumlahAnggota;
			tanggalLahir = tanggalLahirArr[2].replace(" ", "");
			short umur = (short) (2018 - Integer.parseInt(tanggalLahir));
			String tempat = ""; 
			String kabupaten = "";


			// Menyiapkan data untuk lokasi apartemen
			if (0 <= umur && umur <= 18) {
				tempat = "PPMT";
				kabupaten = "Rotunda";
			} else if ( 0 <= anggaran && anggaran <= 100000000 && 19 <= umur && umur <= 1018) {
				tempat = "Teksas";
				kabupaten = "Sastra";
			} else if ( anggaran <= 100000001 && 19 <= umur && umur <= 1018) {
				tempat = "Mares";
				kabupaten = "Margonda";
			}

			// Cetak data rekomendasi apartemen
			String rekomendasi = "\nREKOMENDASI APARTEMEN\n--------------------" + 
			"\nMENGETAHUI: Identitas keluarga: " + nama + " - " + nomorKeluarga +
			"\nMENIMBANG : Anggaran makanan tahunan: Rp" + anggaran +
			"\n            Umur kepala keluarga: " + umur + " tahun" +
			"\nMEMUTUSKAN: keluarga " + nama + " akan ditempatkan di: " +
			tempat + ", kabupaten " + kabupaten;
			System.out.println(rekomendasi);


		} else {
			// Cetak bahwa sang keluarga tidak perlu direlokasi
			System.out.println("\nWARNING: Keluarga ini tidak perlu direlokasi!");
		}
		input.close();
	}
}
