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
import dao.MstProvinsiDao;
import entity.MstKaryawan;
import entity.MstKota;
import entity.MstProvinsi;

@Repository
public class MstKotaDaoImpl implements MstKotaDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstProvinsiDao mstProvinsiDao;

	@Override
	public void save(MstKota mstKota) {
		String query = "insert into MST_KOTA"
				+ "(KODE_KOTA, NAMA_KOTA, KODE_PROVINSI)" + "values(?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKota.getKodeKota());
			ps.setString(2, mstKota.getNamaKota());
			ps.setString(3, mstKota.getMstProvinsi().getKodeProvinsi());

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
	public void update(MstKota mstKota) {
		String query = "update MST_KOTA " + "set NAMA_KOTA=?"
				+ "where KODE_KOTA=? and KODE_PROVINSI=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, mstKota.getNamaKota());
			ps.setString(2, mstKota.getKodeKota());
			ps.setString(3, mstKota.getMstProvinsi().getKodeProvinsi());

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
	public void delete(String kodeKota) {
		String query = "DELETE FROM MST_KOTA where KODE_KOTA=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeKota);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Kota telah dihapus dengan KotaID = "
						+ kodeKota);
			} else {
				System.out.println("Tidak menemukan Kota dengan KotaID = "
						+ kodeKota);
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
	public List<MstKota> findAll() {
		String query = "select * from MST_KOTA";

		List<MstKota> listKota = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MstKota mstKota = new MstKota();
				MstProvinsi mstProvinsi = new MstProvinsi();
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstKota.setNamaKota(rs.getString("NAMA_KOTA"));
				String kode = (rs.getString("KODE_PROVINSI"));
				mstProvinsi = mstProvinsiDao.findOne(kode);
				mstKota.setMstProvinsi(mstProvinsi);

				listKota.add(mstKota);
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
		return listKota;

	}

	@Override
	public MstKota findOne(String kodeKota) {
		String query = "SELECT * from MST_KOTA where KODE_KOTA = '" + kodeKota
				+ "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MstKota mstKota = new MstKota();
		MstProvinsi mstProvinsi = new MstProvinsi();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstKota.setNamaKota(rs.getString("NAMA_KOTA"));
				String kode = (rs.getString("KODE_PROVINSI"));
				mstProvinsi = mstProvinsiDao.findOne(kode);
				mstKota.setMstProvinsi(mstProvinsi);
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

		return mstKota;
	}

	@Override
	public List<MstKota> findKotaProv(String kodeProv) {
		String query = "select KODE_KOTA, NAMA_KOTA from MST_KOTA WHERE KODE_PROVINSI= '"
				+ kodeProv + "'";

		List<MstKota> listKota = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				MstKota mstKota = new MstKota();
				mstKota.setKodeKota(rs.getString("KODE_KOTA"));
				mstKota.setNamaKota(rs.getString("NAMA_KOTA"));

				listKota.add(mstKota);
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
		return listKota;
	}

}
