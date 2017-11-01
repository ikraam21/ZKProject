package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstBarangDao;
import entity.MstBarang;
import service.MstBarangSvc;

@Service("mstBarangSvc")
public class MstBarangSvcImpl implements MstBarangSvc{

	@Autowired
	MstBarangDao mstBarangDao;
	
	@Override
	public List<MstBarang> findAllData() {
		return mstBarangDao.findAll();
	}

	@Override
	public void save(MstBarang mstBarang) {
		mstBarangDao.save(mstBarang);
	}

	@Override
	public void update(MstBarang mstBarang) {
		mstBarangDao.update(mstBarang);
	}

	@Override
	public void delete(String kodeBarang) {
		mstBarangDao.delete(kodeBarang);
	}

	@Override
	public MstBarang findOne(String kodeBarang) {
		return mstBarangDao.findOne(kodeBarang);
	}

	@Override
	public void updateStok(MstBarang mstBarang) {
		mstBarangDao.updateStok(mstBarang);
		
	}
	
}
