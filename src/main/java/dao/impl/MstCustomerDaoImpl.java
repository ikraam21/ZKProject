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

import dao.MstCustomerDao;
import dao.MstKotaDao;
import dao.MstProvinsiDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.MstKota;
import service.MstCustomerSvc;

@Repository
public class MstCustomerDaoImpl implements MstCustomerDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstKotaDao mstKotaDao;

	@Autowired
	MstProvinsiDao mstProvinsiDao;

	@Override
	public List<MstCustomer> findAll() {
		String query = "select * from MST_CUSTOMER";

		List<MstCustomer> listCustomer = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MstCustomer mstCustomer = new MstCustomer();
				MstKota mstKota = new MstKota();
				mstCustomer.setKodeCustomer(rs.getString("KODE_CUSTOMER"));
				mstCustomer.setNamaCustomer(rs.getString("NAMA_CUSTOMER"));
				mstCustomer.setAlamatCustomer(rs.getString("ALAMAT_CUSTOMER"));
				mstCustomer.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstCustomer.setEmailCustomer(rs.getString("EMAIL_CUSTOMER"));
				String kode = (rs.getString("KODE_KOTA"));
				mstKota = mstKotaDao.findOne(kode);
				mstCustomer.setMstKota(mstKota);

				listCustomer.add(mstCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return listCustomer;
	}

	@Override
	public void save(MstCustomer mstCustomer) {
		String query = "INSERT INTO MST_CUSTOMER"
				+ "(KODE_CUSTOMER, NAMA_CUSTOMER, ALAMAT_CUSTOMER, JENIS_KELAMIN, EMAIL_CUSTOMER, KODE_KOTA)"
				+ "values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstCustomer.getKodeCustomer());
			ps.setString(2, mstCustomer.getNamaCustomer());
			ps.setString(3, mstCustomer.getAlamatCustomer());
			ps.setString(4, mstCustomer.getJenisKelamin());
			ps.setString(5, mstCustomer.getEmailCustomer());
			ps.setString(6, mstCustomer.getMstKota().getKodeKota());

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Sukses");
			} else {
				System.out.println("Gagal");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(MstCustomer mstCustomer) {
		String query = "update MST_CUSTOMER "
				+ "set NAMA_CUSTOMER=?, ALAMAT_CUSTOMER=?, JENIS_KELAMIN=?, EMAIL_CUSTOMER=?, KODE_KOTA=? "
				+ "where KODE_CUSTOMER=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstCustomer.getNamaCustomer());
			ps.setString(2, mstCustomer.getAlamatCustomer());
			ps.setString(3, mstCustomer.getJenisKelamin());
			ps.setString(4, mstCustomer.getEmailCustomer());
			ps.setString(5, mstCustomer.getMstKota().getKodeKota());
			ps.setString(6, mstCustomer.getKodeCustomer());

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Update Sukses");
			} else {
				System.out.println("Update Gagal");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String kodeCustomer) {
		String query = "DELETE FROM MST_CUSTOMER where KODE_CUSTOMER=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeCustomer);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Customer telah dihapus dengan CustomerID = "
						+ kodeCustomer);
			} else {
				System.out.println("Tidak menemukan Customer dengan CustomerID = "
						+ kodeCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public MstCustomer findOne(String kodeCustomer) {
		String query = "select * from MST_CUSTOMER where KODE_CUSTOMER = '"
				+ kodeCustomer + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstCustomer mstCustomer = new MstCustomer();
		MstKota mstKota = new MstKota();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstCustomer.setKodeCustomer(rs.getString("KODE_CUSTOMER"));
				mstCustomer.setNamaCustomer(rs.getString("NAMA_CUSTOMER"));
				mstCustomer.setAlamatCustomer(rs.getString("ALAMAT_CUSTOMER"));
				mstCustomer.setJenisKelamin(rs.getString("JENIS_KELAMIN"));
				mstCustomer.setEmailCustomer(rs.getString("EMAIL_CUSTOMER"));
				String kode = (rs.getString("KODE_KOTA"));
				mstKota = mstKotaDao.findOne(kode);
				mstCustomer.setMstKota(mstKota);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mstCustomer;
	}

}
