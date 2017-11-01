package dao;

import java.util.List;

import entity.TrHeaderPenjualan;

public interface TrHeaderPenjualanDao {
	public void save(TrHeaderPenjualan trHeaderPenjualan);
	public void update(TrHeaderPenjualan trHeaderPenjualan);
	public void delete(String noNota);
	public List<TrHeaderPenjualan> findAll();
	public TrHeaderPenjualan findOne(String noNota);
	public void deleteDetail(String noNota);
	public List<TrHeaderPenjualan> searchData(String key);
}
