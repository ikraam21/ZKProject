package dao;

import java.util.List;

import entity.MstProvinsi;

public interface MstProvinsiDao {
	public void save(MstProvinsi mstProvinsi);
	public void update(MstProvinsi mstProvinsi);
	public void delete(String kodeProvinsi);
	public List<MstProvinsi> findAll();
	public MstProvinsi findOne(String kodeProvinsi);
}
