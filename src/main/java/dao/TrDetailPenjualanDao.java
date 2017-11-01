package dao;

import java.util.List;

import entity.TrDetailPenjualan;

public interface TrDetailPenjualanDao {
	public void save(TrDetailPenjualan trDetailPenjualan);
	public void update(TrDetailPenjualan trDetailPenjualan);
	public void delete(String kodeDetail);
	public List<TrDetailPenjualan> findAll();
	public TrDetailPenjualan findOne(String kodeDetail);
	public List<TrDetailPenjualan> findByHeader(String nomerNota);
}
