package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import service.MstKaryawanSvc;
import dao.MstKaryawanDao;
import entity.MstKaryawan;

@Repository
public class MstKaryawanDaoImpl implements MstKaryawanDao{

	@Autowired
	DataSource dataSource;
	
	@Override
	public void save(MstKaryawan mstKaryawan) {
		String query = "insert into MST_KARYAWAN"
				+ "(KODE_KARYAWAN, NAMA_KARYAWAN, USERNAME, PASSWORD)"
				+ "values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKaryawan.getKodeKaryawan());
			ps.setString(2, mstKaryawan.getNamaKaryawan());
			ps.setString(3, mstKaryawan.getUsername());
			ps.setString(4, mstKaryawan.getPassword());
			
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			}else{
				System.out.println("Gagal");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(MstKaryawan mstKaryawan) {
		String query = "update MST_KARYAWAN "
				+ "set Nama_Karyawan=?, USERNAME=?, PASSWORD=? "
				+ "where KODE_KARYAWAN=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKaryawan.getNamaKaryawan());
			ps.setString(2, mstKaryawan.getUsername());
			ps.setString(3, mstKaryawan.getPassword());
			ps.setString(4, mstKaryawan.getKodeKaryawan());
			
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Update Sukses");
			}else {
				System.out.println("Update Gagal");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(String kodeKaryawan) {
		String query = "delete from MST_KARYAWAN where KODE_KARYAWAN=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeKaryawan);
			
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Karyawan telah dihapus dengan ID=" + kodeKaryawan);
			}else {
				System.out.println("Tidak menemukan Karyawan dengan ID=" + kodeKaryawan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public List<MstKaryawan> findAll() {
		String query = "select * from MST_KARYAWAN";
		
		List<MstKaryawan> listKaryawan = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				MstKaryawan mstKaryawan = new MstKaryawan();
				mstKaryawan.setKodeKaryawan(rs.getString("KODE_KARYAWAN"));
				mstKaryawan.setNamaKaryawan(rs.getString("NAMA_KARYAWAN"));
				mstKaryawan.setUsername(rs.getString("USERNAME"));
				mstKaryawan.setPassword(rs.getString("PASSWORD"));
				
				listKaryawan.add(mstKaryawan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return listKaryawan;
	}

	@Override
	public MstKaryawan findOne(String msString) {
		String query = "select * from MST_KARYAWAN where KODE_KARYAWAN = '"+msString+"'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstKaryawan mstKaryawan = new MstKaryawan();
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstKaryawan.setKodeKaryawan(rs.getString("KODE_KARYAWAN"));
				mstKaryawan.setNamaKaryawan(rs.getString("NAMA_KARYAWAN"));
				mstKaryawan.setUsername(rs.getString("USERNAME"));
				mstKaryawan.setPassword(rs.getString("PASSWORD"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mstKaryawan;
	}

	@Override
	public MstKaryawan findByUsernamaAndPassword(String username,
			String password) {
			String query = "SELECT * FROM MST_KARYAWAN "
					+ "WHERE USERNAME = '"+username+"' AND PASSWORD = '"+password+"'";
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			MstKaryawan mstKaryawan = new MstKaryawan();
			
			try{
				con = dataSource.getConnection();
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()){
					mstKaryawan.setKodeKaryawan(rs.getString("KODE_KARYAWAN"));
					mstKaryawan.setNamaKaryawan(rs.getString("NAMA_KARYAWAN"));
					mstKaryawan.setUsername(rs.getString("USERNAME"));
					mstKaryawan.setPassword(rs.getString("PASSWORD"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					ps.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		return mstKaryawan;
	}
	
}
