package service;

import java.util.List;

import entity.TrDetailPenjualan;

public interface TrDetailPenjualanSvc {
	public List<TrDetailPenjualan> findAllData();

	public void save(TrDetailPenjualan trDetailPenjualan);

	public void update(TrDetailPenjualan trDetailPenjualan);

	public void delete(String kodeDetail);

	public TrDetailPenjualan findOne(String kodeDetail);
	
	public List<TrDetailPenjualan> findByHeader(String nomerNota);
}
