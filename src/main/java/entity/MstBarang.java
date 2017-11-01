package entity;

public class MstBarang {
	private String kodeBarang;
	private String namaBarang;
	private int stokBarang;
	private MstSupplier mstSupplier;
		
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public int getStokBarang() {
		return stokBarang;
	}
	public void setStokBarang(int stokBarang) {
		this.stokBarang = stokBarang;
	}
	public MstSupplier getMstSupplier() {
		return mstSupplier;
	}
	public void setMstSupplier(MstSupplier mstSupplier) {
		this.mstSupplier = mstSupplier;
	}


	
	
}
