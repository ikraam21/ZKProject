package service;

import java.util.List;

import entity.MstSupplier;

public interface MstSupplierSvc {
	public List<MstSupplier> findAllData();

	public void save(MstSupplier mstSupplier);

	public void update(MstSupplier mstSupplier);

	public void delete(String kodeSupplier);

	public MstSupplier findOne(String kodeSupplier);
}
