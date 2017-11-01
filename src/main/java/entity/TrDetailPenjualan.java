package entity;

public class TrDetailPenjualan {
	private String kodeDetail;
	private int qty;
	private double subTotal;
	private int diskon;
	private double hargaSatuan;
	private MstBarang mstBarang;
	private TrHeaderPenjualan trHeaderPenjualan;
	
	public String getKodeDetail() {
		return kodeDetail;
	}
	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public int getDiskon() {
		return diskon;
	}
	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}
	public double getHargaSatuan() {
		return hargaSatuan;
	}
	public void setHargaSatuan(double hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}
	public MstBarang getMstBarang() {
		return mstBarang;
	}
	public void setMstBarang(MstBarang mstBarang) {
		this.mstBarang = mstBarang;
	}
	public TrHeaderPenjualan getTrHeaderPenjualan() {
		return trHeaderPenjualan;
	}
	public void setTrHeaderPenjualan(TrHeaderPenjualan trHeaderPenjualan) {
		this.trHeaderPenjualan = trHeaderPenjualan;
	}



	
	
}
