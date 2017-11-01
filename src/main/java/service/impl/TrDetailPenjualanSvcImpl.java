package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TrDetailPenjualanDao;
import entity.TrDetailPenjualan;
import service.TrDetailPenjualanSvc;


@Service("trDetailPenjualanSvc")
public class TrDetailPenjualanSvcImpl implements TrDetailPenjualanSvc{

	@Autowired
	TrDetailPenjualanDao trDetailPenjualanDao;
	
	@Override
	public List<TrDetailPenjualan> findAllData() {
		return trDetailPenjualanDao.findAll();
	}

	@Override
	public void save(TrDetailPenjualan trDetailPenjualan) {
		trDetailPenjualanDao.save(trDetailPenjualan);
	}

	@Override
	public void update(TrDetailPenjualan trDetailPenjualan) {
		trDetailPenjualanDao.update(trDetailPenjualan);
	}

	@Override
	public void delete(String kodeDetail) {
		trDetailPenjualanDao.delete(kodeDetail);
	}

	@Override
	public TrDetailPenjualan findOne(String kodeDetail) {
		return trDetailPenjualanDao.findOne(kodeDetail);
	}

	@Override
	public List<TrDetailPenjualan> findByHeader(String nomerNota) {
		return trDetailPenjualanDao.findByHeader(nomerNota);
	}

}
