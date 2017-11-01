package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrHeaderPenjualanDao;
import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

@Service("trHeaderPenjualanSvc")
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc{

	@Autowired
	TrHeaderPenjualanDao trHeaderPenjualanDao;
	
	@Override
	public List<TrHeaderPenjualan> findAllData() {
		return trHeaderPenjualanDao.findAll();
	}

	@Override
	public void save(TrHeaderPenjualan trHeaderPenjualan) {
		trHeaderPenjualanDao.save(trHeaderPenjualan);
		
	}

	@Override
	public void update(TrHeaderPenjualan trHeaderPenjualan) {
		trHeaderPenjualanDao.update(trHeaderPenjualan);
	}

	@Override
	public void delete(String noNota) {
		trHeaderPenjualanDao.delete(noNota);
	}

	@Override
	public TrHeaderPenjualan findOne(String noNota) {
		return trHeaderPenjualanDao.findOne(noNota);
	}

	@Override
	public void deleteDetail(String noNota) {
		trHeaderPenjualanDao.deleteDetail(noNota);
		
	}

	@Override
	public List<TrHeaderPenjualan> searchData(String key) {
		return trHeaderPenjualanDao.searchData(key);
	}

}
