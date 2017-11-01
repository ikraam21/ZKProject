package dao;

import java.util.List;

import entity.MstKaryawan;

public interface MstKaryawanDao {
	public void save(MstKaryawan mstKaryawan);
	public void update(MstKaryawan mstKaryawan);
	public void delete(String kodeKaryawan);
	public List<MstKaryawan> findAll();
	public MstKaryawan findOne(String msString);
	public MstKaryawan findByUsernamaAndPassword(String username, String password);
}
