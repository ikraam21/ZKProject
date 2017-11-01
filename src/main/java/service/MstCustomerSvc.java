package service;

import java.util.List;

import entity.MstCustomer;
import entity.MstKota;

public interface MstCustomerSvc {
	public List<MstCustomer> findAllData();

	public void save(MstCustomer mstCustomer);

	public void update(MstCustomer mstCustomer);

	public void delete(String kodeCustomer);

	public MstCustomer findOne(String kodeCustomer);
	
	public List<MstKota> findByProv(String kodeProvinsi);
}
