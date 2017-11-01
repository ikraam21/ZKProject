package entity;

public class MstCustomer {
	private String kodeCustomer;
	private String namaCustomer;
	private String alamatCustomer;
	private String jenisKelamin;
	private String emailCustomer;
	private MstKota mstKota;
	
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public String getNamaCustomer() {
		return namaCustomer;
	}
	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}
	public String getAlamatCustomer() {
		return alamatCustomer;
	}
	public void setAlamatCustomer(String alamatCustomer) {
		this.alamatCustomer = alamatCustomer;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getEmailCustomer() {
		return emailCustomer;
	}
	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}
	public MstKota getMstKota() {
		return mstKota;
	}
	public void setMstKota(MstKota mstKota) {
		this.mstKota = mstKota;
	}
  
	
	
}
