package entity;

public class MstKota {
	private String kodeKota;
	private String namaKota;
	private MstProvinsi mstProvinsi;
	
	public String getKodeKota() {
		return kodeKota;
	}
	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}
	public String getNamaKota() {
		return namaKota;
	}
	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}
	public MstProvinsi getMstProvinsi() {
		return mstProvinsi;
	}
	public void setMstProvinsi(MstProvinsi mstProvinsi) {
		this.mstProvinsi = mstProvinsi;
	}

}
