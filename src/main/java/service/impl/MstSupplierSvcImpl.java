package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstSupplierDao;
import entity.MstSupplier;
import service.MstSupplierSvc;

@Service("mstSupplierSvc")
public class MstSupplierSvcImpl implements MstSupplierSvc{

	@Autowired
	MstSupplierDao mstSupplierDao;
	
	@Override
	public List<MstSupplier> findAllData() {
		return mstSupplierDao.findAll();
	}

	@Override
	public void save(MstSupplier mstSupplier) {
		mstSupplierDao.save(mstSupplier);
	}

	@Override
	public void update(MstSupplier mstSupplier) {
		mstSupplierDao.update(mstSupplier);
	}

	@Override
	public void delete(String kodeSupplier) {
		mstSupplierDao.delete(kodeSupplier);
	}

	@Override
	public MstSupplier findOne(String kodeSupplier) {
		return mstSupplierDao.findOne(kodeSupplier);
	}

	
}
