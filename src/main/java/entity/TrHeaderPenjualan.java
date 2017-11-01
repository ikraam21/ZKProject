package entity;

import java.sql.Date;

public class TrHeaderPenjualan {
	private String noNota;
	private Date tanggalTransaksi;
	private double hargaTotal;
	private int globalDiskon;
	private MstCustomer mstCustomer;
	private MstKaryawan mstKaryawan;
	
	public String getNoNota() {
		return noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}
	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	public double getHargaTotal() {
		return hargaTotal;
	}
	public void setHargaTotal(double hargaTotal) {
		this.hargaTotal = hargaTotal;
	}
	public int getGlobalDiskon() {
		return globalDiskon;
	}
	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}
	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}
	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}
	public MstKaryawan getMstKaryawan() {
		return mstKaryawan;
	}
	public void setMstKaryawan(MstKaryawan mstKaryawan) {
		this.mstKaryawan = mstKaryawan;
	}



	
	
}
