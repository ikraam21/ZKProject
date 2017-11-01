package service;

import java.util.List;

import entity.MstBarang;

public interface MstBarangSvc {
	public List<MstBarang> findAllData();

	public void save(MstBarang mstBarang);

	public void update(MstBarang mstBarang);

	public void delete(String kodeBarang);

	public MstBarang findOne(String kodeBarang);
	
	public void updateStok(MstBarang mstBarang);
}
