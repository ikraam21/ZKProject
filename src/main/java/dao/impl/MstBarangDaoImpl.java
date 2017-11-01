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

import dao.MstBarangDao;
import dao.MstSupplierDao;
import entity.MstBarang;
import entity.MstKota;
import entity.MstSupplier;

@Repository
public class MstBarangDaoImpl implements MstBarangDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstSupplierDao mstSupplierDao;

	@Override
	public void save(MstBarang mstBarang) {
		String query = "INSERT INTO MST_BARANG"
				+ "(KODE_BARANG, NAMA_BARANG, STOK_BARANG, KODE_SUPPLIER)"
				+ "values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstBarang.getKodeBarang());
			ps.setString(2, mstBarang.getNamaBarang());
			ps.setInt(3, mstBarang.getStokBarang());
			ps.setString(4, mstBarang.getMstSupplier().getKodeSupplier());

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
	public void update(MstBarang mstBarang) {
		String query = "update MST_BARANG "
				+ "set NAMA_BARANG=?, STOK_BARANG=?, KODE_SUPPLIER=? "
				+ "where KODE_BARANG=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstBarang.getNamaBarang());
			ps.setInt(2, mstBarang.getStokBarang());
			ps.setString(3, mstBarang.getMstSupplier().getKodeSupplier());
			ps.setString(4, mstBarang.getKodeBarang());

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
	public void delete(String kodeBarang) {
		String query = "DELETE FROM MST_BARANG where KODE_BARANG=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeBarang);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Barang telah dihapus dengan BarangID = "
						+ kodeBarang);
			} else {
				System.out.println("Tidak menemukan Barang dengan BarangID = "
						+ kodeBarang);
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
	public List<MstBarang> findAll() {
		String query = "select * from MST_BARANG";

		List<MstBarang> listBarang = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MstBarang mstBarang = new MstBarang();
				MstSupplier mstSupplier = new MstSupplier();
				mstBarang.setKodeBarang(rs.getString("KODE_BARANG"));
				mstBarang.setNamaBarang(rs.getString("NAMA_BARANG"));
				mstBarang.setStokBarang(rs.getInt("STOK_BARANG"));
				String kode = (rs.getString("KODE_SUPPLIER"));
				mstSupplier = mstSupplierDao.findOne(kode);
				mstBarang.setMstSupplier(mstSupplier);
				listBarang.add(mstBarang);
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
		return listBarang;
	}

	@Override
	public MstBarang findOne(String kodeBarang) {
		String query = "select * from MST_BARANG where KODE_BARANG = '"
				+ kodeBarang + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstBarang mstBarang = new MstBarang();
		MstSupplier mstSupplier = new MstSupplier();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstBarang.setKodeBarang(rs.getString("KODE_BARANG"));
				mstBarang.setNamaBarang(rs.getString("NAMA_BARANG"));
				mstBarang.setStokBarang(rs.getInt("STOK_BARANG"));
				String kode = (rs.getString("KODE_SUPPLIER"));
				mstSupplier = mstSupplierDao.findOne(kode);
				mstBarang.setMstSupplier(mstSupplier);
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

		return mstBarang;
	}

	@Override
	public void updateStok(MstBarang mstBarang) {
		String query = "update MST_BARANG "
				+ "set STOK_BARANG=? where KODE_BARANG=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, mstBarang.getStokBarang());
			ps.setString(2, mstBarang.getKodeBarang());

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

}
