package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstProvinsiDao;
import entity.MstProvinsi;
import service.MstProvinsiSvc;

@Service("mstProvinsiSvc")
public class MstProvinsiSvcImpl implements MstProvinsiSvc{

	@Autowired
	private MstProvinsiDao mstProvinsiDao;
	
	@Override
	public List<MstProvinsi> findAllData() {
		return mstProvinsiDao.findAll();
	}

	@Override
	public void save(MstProvinsi mstProvinsi) {
		mstProvinsiDao.save(mstProvinsi);
	}

	@Override
	public void update(MstProvinsi mstProvinsi) {
		mstProvinsiDao.update(mstProvinsi);
	}

	@Override
	public void delete(String kodeProvinsi) {
		mstProvinsiDao.delete(kodeProvinsi);
	}

	@Override
	public MstProvinsi findOne(String kodeProvinsi) {
		return mstProvinsiDao.findOne(kodeProvinsi);
	}

}
