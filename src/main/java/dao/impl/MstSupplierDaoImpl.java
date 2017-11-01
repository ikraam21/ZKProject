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

import dao.MstKotaDao;
import dao.MstSupplierDao;
import entity.MstKota;
import entity.MstSupplier;

@Repository
public class MstSupplierDaoImpl implements MstSupplierDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstKotaDao mstKotaDao;

	@Override
	public void save(MstSupplier mstSupplier) {
		String query = "INSERT INTO MST_SUPPLIER"
				+ "(KODE_SUPPLIER, NAMA_SUPPLIER, ALAMAT_SUPPLIER, TELP_SUPPLIER, EMAIL_SUPPLIER, KODE_KOTA)"
				+ "values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstSupplier.getKodeSupplier());
			ps.setString(2, mstSupplier.getAlamatSupplier());
			ps.setString(3, mstSupplier.getNamaSupplier());
			ps.setString(4, mstSupplier.getTelpSupplier());
			ps.setString(5, mstSupplier.getEmailSupplier());
			ps.setString(6, mstSupplier.getMstKota().getKodeKota());

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
	public void update(MstSupplier mstSupplier) {
		String query = "update MST_SUPPLIER "
				+ "set NAMA_SUPPLIER=?, ALAMAT_SUPPLIER=?, TELP_SUPPLIER=?, EMAIL_SUPPLIER=?, KODE_KOTA=? "
				+ "where KODE_SUPPLIER=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstSupplier.getNamaSupplier());
			ps.setString(2, mstSupplier.getAlamatSupplier());
			ps.setString(3, mstSupplier.getTelpSupplier());
			ps.setString(4, mstSupplier.getEmailSupplier());
			ps.setString(5, mstSupplier.getMstKota().getKodeKota());
			ps.setString(6, mstSupplier.getKodeSupplier());

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
	public void delete(String kodeSupplier) {
		String query = "DELETE FROM MST_SUPPLIER where KODE_SUPPLIER=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeSupplier);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out
						.println("Supplier telah dihapus dengan SupplierID = "
								+ kodeSupplier);
			} else {
				System.out
						.println("Tidak menemukan Supplier dengan SupplierID = "
								+ kodeSupplier);
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
	public List<MstSupplier> findAll() {
		String query = "select * from MST_SUPPLIER";

		List<MstSupplier> listSupplier = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MstSupplier mstSupplier = new MstSupplier();
				MstKota mstKota = new MstKota();
				mstSupplier.setKodeSupplier(rs.getString("KODE_SUPPLIER"));
				mstSupplier.setNamaSupplier(rs.getString("NAMA_SUPPLIER"));
				mstSupplier.setAlamatSupplier(rs.getString("ALAMAT_SUPPLIER"));
				mstSupplier.setTelpSupplier(rs.getString("TELP_SUPPLIER"));
				mstSupplier.setEmailSupplier(rs.getString("EMAIL_SUPPLIER"));
				String kode = (rs.getString("KODE_KOTA"));
				mstKota = mstKotaDao.findOne(kode);
				mstSupplier.setMstKota(mstKota);

				listSupplier.add(mstSupplier);
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
		return listSupplier;
	}

	@Override
	public MstSupplier findOne(String kodeSupplier) {
		String query = "select * from MST_SUPPLIER where KODE_SUPPLIER = '"
				+ kodeSupplier + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstSupplier mstSupplier = new MstSupplier();
		MstKota mstKota = new MstKota();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstSupplier.setKodeSupplier(rs.getString("KODE_SUPPLIER"));
				mstSupplier.setNamaSupplier(rs.getString("NAMA_SUPPLIER"));
				mstSupplier.setAlamatSupplier(rs.getString("ALAMAT_SUPPLIER"));
				mstSupplier.setTelpSupplier(rs.getString("TELP_SUPPLIER"));
				mstSupplier.setEmailSupplier(rs.getString("EMAIL_SUPPLIER"));
				String kode = (rs.getString("KODE_KOTA"));
				mstKota = mstKotaDao.findOne(kode);
				mstSupplier.setMstKota(mstKota);
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

		return mstSupplier;
	}

}
