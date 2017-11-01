package service;

import java.util.List;

import entity.TrHeaderPenjualan;

public interface TrHeaderPenjualanSvc {
	public List<TrHeaderPenjualan> findAllData();

	public void save(TrHeaderPenjualan trHeaderPenjualan);

	public void update(TrHeaderPenjualan trHeaderPenjualan);

	public void delete(String noNota);

	public TrHeaderPenjualan findOne(String noNota);
	
	public void deleteDetail(String noNota);
	
	public List<TrHeaderPenjualan> searchData(String key);
}
