package vmd;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;

public class BindVmd {
	private String nama;
	private double alas;
	private double tinggi;
	public double luas;
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public double getAlas() {
		return alas;
	}
	public void setAlas(double alas) {
		this.alas = alas;
	}
	public double getTinggi() {
		return tinggi;
	}
	public void setTinggi(double tinggi) {
		this.tinggi = tinggi;
	}
	public double getLuas() {
		return luas;
	}
	public void setLuas(double luas) {
		this.luas = luas;
	}
	
	
	@Command("hitung")
	@NotifyChange("luas")
	public void hitungLuas(){
		luas = 0.5 * alas * tinggi;
		System.out.println("Luas segitiga adalah: " + luas);
		Messagebox.show("Luas segitiga adalah: " + luas);
	}
	
	@Command("klik")
	public void klik(){
		System.out.println("Klik di eksekusi: " + nama);
		Messagebox.show("Anda menuliskan: " + nama);
	}
}
