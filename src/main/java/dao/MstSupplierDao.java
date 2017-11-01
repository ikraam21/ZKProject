package dao;

import java.util.List;

import entity.MstSupplier;

public interface MstSupplierDao {
	public void save(MstSupplier mstSupplier);
	public void update(MstSupplier mstSupplier);
	public void delete(String kodeSupplier);
	public List<MstSupplier> findAll();
	public MstSupplier findOne(String kodeSupplier);
}
