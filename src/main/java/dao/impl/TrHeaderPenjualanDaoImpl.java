package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.MstCustomerDao;
import dao.MstKaryawanDao;
import dao.TrHeaderPenjualanDao;
import entity.MstCustomer;
import entity.MstKaryawan;
import entity.TrHeaderPenjualan;

@Repository
public class TrHeaderPenjualanDaoImpl implements TrHeaderPenjualanDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstCustomerDao mstCustomerDao;

	@Autowired
	MstKaryawanDao mstKaryawanDao;

	@Override
	public void save(TrHeaderPenjualan trHeaderPenjualan) {
		String query = "INSERT INTO TR_HEADER_PENJUALAN"
				+ "(NO_NOTA, TANGGAL_TRANSAKSI, HARGA_TOTAL, GLOBAL_DISKON, KODE_CUSTOMER, KODE_KARYAWAN)"
				+ "values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, trHeaderPenjualan.getNoNota());
			ps.setDate(2, (Date) trHeaderPenjualan.getTanggalTransaksi());
			ps.setDouble(3, trHeaderPenjualan.getHargaTotal());
			ps.setInt(4, trHeaderPenjualan.getGlobalDiskon());
			ps.setString(5, trHeaderPenjualan.getMstCustomer()
					.getKodeCustomer());
			ps.setString(6, trHeaderPenjualan.getMstKaryawan()
					.getKodeKaryawan());

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
	public void update(TrHeaderPenjualan trHeaderPenjualan) {
		String query = "update TR_HEADER_PENJUALAN "
				+ "set TANGGAL_TRANSAKSI=?, HARGA_TOTAL=?, GLOBAL_DISKON=?, KODE_CUSTOMER=?, KODE_KARYAWAN=? "
				+ "where NO_NOTA=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setDate(1, (Date) trHeaderPenjualan.getTanggalTransaksi());
			ps.setDouble(2, trHeaderPenjualan.getHargaTotal());
			ps.setInt(3, trHeaderPenjualan.getGlobalDiskon());
			ps.setString(4, trHeaderPenjualan.getMstCustomer()
					.getKodeCustomer());
			ps.setString(5, trHeaderPenjualan.getMstKaryawan()
					.getKodeKaryawan());
			ps.setString(6, trHeaderPenjualan.getNoNota());

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
	public void delete(String noNota) {
		String query = "DELETE FROM TR_HEADER_PENJUALAN where NO_NOTA=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, noNota);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out
						.println("Header Penjualan telah dihapus dengan NoNota = "
								+ noNota);
			} else {
				System.out
						.println("Tidak menemukan Header Penjualan dengan NoNota = "
								+ noNota);
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
	public List<TrHeaderPenjualan> findAll() {
		String query = "select * from TR_HEADER_PENJUALAN";

		List<TrHeaderPenjualan> listTrHeaderPenjualan = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
				MstCustomer mstCustomer = new MstCustomer();
				MstKaryawan mstKaryawan = new MstKaryawan();
				trHeaderPenjualan.setNoNota(rs.getString("NO_NOTA"));
				trHeaderPenjualan.setTanggalTransaksi(rs
						.getDate("TANGGAL_TRANSAKSI"));
				trHeaderPenjualan.setHargaTotal(rs.getDouble("HARGA_TOTAL"));
				trHeaderPenjualan.setGlobalDiskon(rs.getInt("GLOBAL_DISKON"));
				String kodeCus = (rs.getString("KODE_CUSTOMER"));
				mstCustomer = mstCustomerDao.findOne(kodeCus);
				trHeaderPenjualan.setMstCustomer(mstCustomer);
				String kodeKar = (rs.getString("KODE_KARYAWAN"));
				mstKaryawan = mstKaryawanDao.findOne(kodeKar);
				trHeaderPenjualan.setMstKaryawan(mstKaryawan);

				listTrHeaderPenjualan.add(trHeaderPenjualan);
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
		return listTrHeaderPenjualan;
	}

	@Override
	public TrHeaderPenjualan findOne(String noNota) {
		String query = "select * from TR_HEADER_PENJUALAN where NO_NOTA = '"
				+ noNota + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
		MstCustomer mstCustomer = new MstCustomer();
		MstKaryawan mstKaryawan = new MstKaryawan();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				trHeaderPenjualan.setNoNota(rs.getString("NO_NOTA"));
				trHeaderPenjualan.setTanggalTransaksi(rs
						.getDate("TANGGAL_TRANSAKSI"));
				trHeaderPenjualan.setHargaTotal(rs.getDouble("HARGA_TOTAL"));
				trHeaderPenjualan.setGlobalDiskon(rs.getInt("GLOBAL_DISKON"));
				String kodeCus = (rs.getString("KODE_CUSTOMER"));
				mstCustomer = mstCustomerDao.findOne(kodeCus);
				trHeaderPenjualan.setMstCustomer(mstCustomer);
				String kodeKar = (rs.getString("KODE_KARYAWAN"));
				mstKaryawan = mstKaryawanDao.findOne(kodeKar);
				trHeaderPenjualan.setMstKaryawan(mstKaryawan);
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

		return trHeaderPenjualan;
	}

	@Override
	public void deleteDetail(String noNota) {
		String query = "DELETE FROM TR_DETAIL_PENJUALAN where NO_NOTA=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, noNota);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out
						.println("Detail Penjualan telah dihapus dengan NoNota = "
								+ noNota);
			} else {
				System.out
						.println("Tidak menemukan Detail Penjualan dengan NoNota = "
								+ noNota);
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
	public List<TrHeaderPenjualan> searchData(String key) {
		String search = ("%"+key+"%");
		
		String query = "SELECT NO_NOTA, TANGGAL_TRANSAKSI, HARGA_TOTAL, GLOBAL_DISKON, TH.KODE_CUSTOMER, TH.KODE_KARYAWAN "
				+ "FROM TR_HEADER_PENJUALAN AS TH JOIN MST_CUSTOMER AS C ON TH.KODE_CUSTOMER=C.KODE_CUSTOMER "
				+ "INNER JOIN MST_KARYAWAN AS K ON TH.KODE_KARYAWAN=K.KODE_KARYAWAN "
				+ "WHERE (NO_NOTA LIKE '"+search+"' OR TANGGAL_TRANSAKSI LIKE '"+search+"' "
				+ "OR HARGA_TOTAL LIKE '"+search+"' OR GLOBAL_DISKON LIKE '"+search+"' "
				+ "OR C.KODE_CUSTOMER LIKE '"+search+"' OR K.KODE_KARYAWAN LIKE '"+search+"')";

		List<TrHeaderPenjualan> listTrHeaderPenjualan = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
				MstCustomer mstCustomer = new MstCustomer();
				MstKaryawan mstKaryawan = new MstKaryawan();
				trHeaderPenjualan.setNoNota(rs.getString("NO_NOTA"));
				trHeaderPenjualan.setTanggalTransaksi(rs
						.getDate("TANGGAL_TRANSAKSI"));
				trHeaderPenjualan.setHargaTotal(rs.getDouble("HARGA_TOTAL"));
				trHeaderPenjualan.setGlobalDiskon(rs.getInt("GLOBAL_DISKON"));
				String kodeCus = (rs.getString("KODE_CUSTOMER"));
				mstCustomer = mstCustomerDao.findOne(kodeCus);
				trHeaderPenjualan.setMstCustomer(mstCustomer);
				String kodeKar = (rs.getString("KODE_KARYAWAN"));
				mstKaryawan = mstKaryawanDao.findOne(kodeKar);
				trHeaderPenjualan.setMstKaryawan(mstKaryawan);

				listTrHeaderPenjualan.add(trHeaderPenjualan);
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
		return listTrHeaderPenjualan;
	}
}
