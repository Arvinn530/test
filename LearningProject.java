import java.util.Scanner;

public class LearningProject {
	class Manusia {
        private String nama;
        private byte umur;
        public long uang = 50000;
        public float kebahagiaan = 50.0;
        Manusia(String nama, byte umur)) {
            this.nama = nama;
            this.umur = umur;
        }

        Manusia(String nama, byte umur, long uang) {
            this.nama = nama;
            this.umur = umur;
            this.uang = uang;
        }

        private float ubahKebahagiaan(float kebahagiaan) {
            if (kebahagiaan > 100.0) {
                return 100.0;
            } else if (kebahagiaan < 0) {
                return 0;
            } else {
                return kebahagiaan;
            }
        }

        public void beriUang(Manusia penerima) {
            int jumlah = 0;
            for(int i=0; i<nama.length(); i++) {
                jumlah += (int) nama.charAt(i);
            }
            jumlah *= 100;
            if (uang < jumlah) {
                System.out.println(this.nama + " ingin memberi uang kepada " +
                    penerima.nama + " namun tidak memiliki cukup uang :'(");
            } else {
                this.uang -= jumlah;
                penerima.uang += jumlah;
                this.kebahagiaan = this.ubahKebahagiaan(jumlah / 6000)
                penerima.kebahagiaan = this.ubahKebahagiaan(jumlah / 6000)
                System.out.println(this.nama + " memberi uang sebanyak " + 
                    jumlah + " kepada " + penerima.nama + ", lalu mereka berdua senang"); 
            }
            return ;
        }

        public void beriUang(Manusia penerima, int jumlah) {
            if (uang < jumlah) {
                System.out.println(this.nama + " memberi uang ");
            } else {
                this.uang -= jumlah;
                penerima.uang += jumlah;
                this.kebahagiaan = this.ubahKebahagiaan(this.kebahagiaan + jumlah / 6000);
                penerima.kebahagiaan = this.ubahKebahagiaan(penerima.kebahagiaan + jumlah / 6000);
                System.out.println(this.nama + " memberi uang sebanyak " + 
                    jumlah + " kepada " + penerima.nama + ", lalu mereka berdua senang"); 
            }
            return ;
        }

        public void bekerja(int durasi, float bebanKerja) {
            if (this.umur < 19) {
                System.out.println(this.nama + " belum boleh bekerja karena masih dibawah umur D:");
                return ; 
            }
            float bebanKerjaTotal;
            int pendapatan;
            if (bebanKerjaTotal > this.kebahagiaan) {
                durasi = (int) kebahagiaan / bebanKerja;
                bebanKerjaTotal = durasi * bebanKerja;
                pendapatan = bebanKerjaTotal * 10000;
                this.uang +=  pendapatan;
                System.out.println(this.nama + 
                    " tidak bekerja secara full time karena sudah terlalu lelah, total pendapatan :  " + 
                    pendapatan);  
            } else {
                bebanKerjaTotal = durasi * bebanKerja;
                pendapatan = bebanKerjaTotal * 10000;
                this.uang += pendapatan;
                this.kebahagiaan -= bebanKerjaTotal;
                System.out.println(this.nama + " bekerja full time, total pendapatan : " + pendapatan);
            } 
            return ;
        }

        public void rekreasi(String namaTempat) {
            int biaya = namaTempat.length() * 10000;
            if (this.uang < biaya) {
                System.out.println(this.nama + " tidak mempunyai cukup uang untuk berekreasi di " + 
                    namaTempat + " :(");
            } else {
                this.uang -= biaya;
                this.kebahagiaan = ubahKebahagiaan(this.kebahagiaan - namaTempat.length());
                System.out.println(this.nama + " berekreasi di " + namaTempat + ", " + 
                    this.nama + " senang :)");
            }
        }

        public void sakit(String penyakit) {
            this.kebahagiaan = ubahKebahagiaan(this.kebahagiaan - penyakit.length());
            System.out.println(this.nama + "terkena penyakit " + penyakit);
        }

        public void toString() {
            System.out.println("Nama\t\t: " + this.nama + "\n" + 
                "Umur\t\t: " + this.umur + "\n" +
                "Uang\t\t: " + this.uang + "\n" +
                "Kebahagiaan\t\t: " + this.kebahagiaan);
        }
    }
	public static void main(String args[]) {

	}

}
