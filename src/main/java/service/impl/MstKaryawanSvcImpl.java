package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstKaryawanDao;
import entity.MstKaryawan;
import service.MstKaryawanSvc;


@Service("mstKaryawanSvc")
public class MstKaryawanSvcImpl implements MstKaryawanSvc {

	@Autowired
	private MstKaryawanDao mstKaryawanDao;
	
	@Override
	public List<MstKaryawan> findAllData() {
		return mstKaryawanDao.findAll();
	}

	@Override
	public void save(MstKaryawan mstKaryawan) {
		mstKaryawanDao.save(mstKaryawan);
	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		mstKaryawanDao.update(mstKaryawan);
	}

	@Override
	public void delete(String kodeKaryawan) {
		mstKaryawanDao.delete(kodeKaryawan);
	}

	@Override
	public MstKaryawan findOne(String kodeKaryawan) {
		return mstKaryawanDao.findOne(kodeKaryawan);
	}

	@Override
	public MstKaryawan login(String username, String password) {
		return mstKaryawanDao.findByUsernamaAndPassword(username, password);
	}
	
}
