package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstCustomerDao;
import dao.MstKotaDao;
import entity.MstCustomer;
import entity.MstKota;
import service.MstCustomerSvc;

@Service("mstCustomerSvc")
public class MstCustomerSvcImpl implements MstCustomerSvc{

	@Autowired
	private MstCustomerDao mstCustomerDao;
	
	@Autowired
	private MstKotaDao mstKotaDao;
	
	
	
	@Override
	public List<MstCustomer> findAllData() {
		return mstCustomerDao.findAll();
	}

	@Override
	public void save(MstCustomer mstCustomer) {
		mstCustomerDao.save(mstCustomer);
	}

	@Override
	public void update(MstCustomer mstCustomer) {
		mstCustomerDao.update(mstCustomer);
	}

	@Override
	public void delete(String kodeCustomer) {
		mstCustomerDao.delete(kodeCustomer);
	}

	@Override
	public MstCustomer findOne(String kodeCustomer) {
		return mstCustomerDao.findOne(kodeCustomer);
	}

	@Override
	public List<MstKota> findByProv(String kodeProvinsi) {
		// TODO Auto-generated method stub
		return mstKotaDao.findKotaProv(kodeProvinsi);
	}

}
