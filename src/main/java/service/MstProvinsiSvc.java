package service;

import java.util.List;

import entity.MstProvinsi;


public interface MstProvinsiSvc {
	public List<MstProvinsi> findAllData();

	public void save(MstProvinsi mstProvinsi);

	public void update(MstProvinsi mstProvinsi);

	public void delete(String kodeProvinsi);

	public MstProvinsi findOne(String kodeProvinsi);
}
