package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstKotaDao;
import entity.MstKota;
import service.MstKotaSvc;

@Service("mstKotaSvc")
public class MstKotaSvcImpl implements MstKotaSvc{

	@Autowired
	MstKotaDao mstKotaDao;
	
	@Override
	public List<MstKota> findAllData() {
		return mstKotaDao.findAll();
	}

	@Override
	public void save(MstKota mstKota) {
		mstKotaDao.save(mstKota);
	}

	@Override
	public void update(MstKota mstKota) {
		mstKotaDao.update(mstKota);
	}

	@Override
	public void delete(String kodeKota) {
		mstKotaDao.delete(kodeKota);
	}

	@Override
	public MstKota findOne(String kodeKota) {
		return mstKotaDao.findOne(kodeKota);
	}

	@Override
	public List<MstKota> findKota(String kodeProv) {
		return mstKotaDao.findKotaProv(kodeProv);
	}


	
}
