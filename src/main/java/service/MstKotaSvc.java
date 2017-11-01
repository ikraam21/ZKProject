package service;

import java.util.List;

import entity.MstKota;


public interface MstKotaSvc {
	public List<MstKota> findAllData();

	public void save(MstKota mstKota);

	public void update(MstKota mstKota);

	public void delete(String kodeKota);

	public MstKota findOne(String kodeKota);
	
	public List<MstKota> findKota(String kodeProv);
}
