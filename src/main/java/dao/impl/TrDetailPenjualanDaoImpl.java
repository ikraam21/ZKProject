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

import dao.MstBarangDao;
import dao.TrDetailPenjualanDao;
import dao.TrHeaderPenjualanDao;
import entity.MstBarang;
import entity.TrDetailPenjualan;
import entity.TrHeaderPenjualan;

@Repository
public class TrDetailPenjualanDaoImpl implements TrDetailPenjualanDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	MstBarangDao mstBarangDao;

	@Autowired
	TrHeaderPenjualanDao trHeaderPenjualanDao;

	@Override
	public void save(TrDetailPenjualan trDetailPenjualan) {
		String query = "INSERT INTO TR_DETAIL_PENJUALAN"
				+ "(KODE_DETAIL, QTY, SUBTOTAL, DISKON, HARGA_SATUAN, KODE_BARANG, NO_NOTA)"
				+ "values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String kode = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, trDetailPenjualan.getKodeDetail());
			ps.setInt(2, trDetailPenjualan.getQty());
			ps.setDouble(3, trDetailPenjualan.getSubTotal());
			ps.setInt(4, trDetailPenjualan.getDiskon());
			ps.setDouble(5, trDetailPenjualan.getHargaSatuan());
			ps.setString(6, trDetailPenjualan.getMstBarang().getKodeBarang());
			ps.setString(7, trDetailPenjualan.getTrHeaderPenjualan()
					.getNoNota());

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
	public void update(TrDetailPenjualan trDetailPenjualan) {
		String query = "update TR_DETAIL_PENJUALAN "
				+ "set QTY=?, SUBTOTAL=?, DISKON=?, HARGA_SATUAN=?, KODE_BARANG=?, NO_NOTA=? "
				+ "where KODE_DETAIL=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, trDetailPenjualan.getQty());
			ps.setDouble(2, trDetailPenjualan.getSubTotal());
			ps.setInt(3, trDetailPenjualan.getDiskon());
			ps.setDouble(4, trDetailPenjualan.getHargaSatuan());
			ps.setString(5, trDetailPenjualan.getMstBarang().getKodeBarang());
			ps.setString(6, trDetailPenjualan.getTrHeaderPenjualan()
					.getNoNota());
			ps.setString(7, trDetailPenjualan.getKodeDetail());

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
	public void delete(String kodeDetail) {
		String query = "DELETE FROM TR_DETAIL_PENJUALAN where KODE_DETAIL=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, kodeDetail);

			int out = ps.executeUpdate();
			if (out != 0) {
				System.out
						.println("Detail Penjualan telah dihapus dengan KodeDetail = "
								+ kodeDetail);
			} else {
				System.out
						.println("Tidak menemukan Detail Penjualan dengan KodeDetail = "
								+ kodeDetail);
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
	public List<TrDetailPenjualan> findAll() {
		String query = "select * from TR_DETAIL_PENJUALAN";

		List<TrDetailPenjualan> listTrDetailPenjualan = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TrDetailPenjualan trDetailPenjualan = new TrDetailPenjualan();
				MstBarang mstBarang = new MstBarang();
				TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();

				trDetailPenjualan.setKodeDetail(rs.getString("KODE_DETAIL"));
				trDetailPenjualan.setQty(rs.getInt("QTY"));
				trDetailPenjualan.setSubTotal(rs.getDouble("SUBTOTAL"));
				trDetailPenjualan.setDiskon(rs.getInt("DISKON"));
				trDetailPenjualan.setHargaSatuan(rs.getDouble("HARGA_SATUAN"));
				String kodeBar = (rs.getString("KODE_BARANG"));
				mstBarang = mstBarangDao.findOne(kodeBar);
				trDetailPenjualan.setMstBarang(mstBarang);
				String noNota = (rs.getString("NO_NOTA"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetailPenjualan.setTrHeaderPenjualan(trHeaderPenjualan);

				listTrDetailPenjualan.add(trDetailPenjualan);
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
		return listTrDetailPenjualan;
	}

	@Override
	public TrDetailPenjualan findOne(String kodeDetail) {
		String query = "select * from TR_DETAIL_PENJUALAN where KODE_DETAIL = '"
				+ kodeDetail + "'";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TrDetailPenjualan trDetailPenjualan = new TrDetailPenjualan();
		TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
		MstBarang mstBarang = new MstBarang();

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				trDetailPenjualan.setKodeDetail(rs.getString("KODE_DETAIL"));
				trDetailPenjualan.setQty(rs.getInt("QTY"));
				trDetailPenjualan.setSubTotal(rs.getDouble("SUBTOTAL"));
				trDetailPenjualan.setDiskon(rs.getInt("DISKON"));
				trDetailPenjualan.setHargaSatuan(rs.getDouble("HARGA_SATUAN"));
				String kodeBar = (rs.getString("KODE_BARANG"));
				mstBarang = mstBarangDao.findOne(kodeBar);
				trDetailPenjualan.setMstBarang(mstBarang);
				String noNota = (rs.getString("NO_NOTA"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetailPenjualan.setTrHeaderPenjualan(trHeaderPenjualan);
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

		return trDetailPenjualan;
	}

	@Override
	public List<TrDetailPenjualan> findByHeader(String nomerNota) {
		String query = "select * from TR_DETAIL_PENJUALAN where NO_NOTA= '"+ nomerNota +"'";

		List<TrDetailPenjualan> listTrDetailPenjualan = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TrDetailPenjualan trDetailPenjualan = new TrDetailPenjualan();
				MstBarang mstBarang = new MstBarang();
				TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();

				trDetailPenjualan.setKodeDetail(rs.getString("KODE_DETAIL"));
				trDetailPenjualan.setQty(rs.getInt("QTY"));
				trDetailPenjualan.setSubTotal(rs.getDouble("SUBTOTAL"));
				trDetailPenjualan.setDiskon(rs.getInt("DISKON"));
				trDetailPenjualan.setHargaSatuan(rs.getDouble("HARGA_SATUAN"));
				String kodeBar = (rs.getString("KODE_BARANG"));
				mstBarang = mstBarangDao.findOne(kodeBar);
				trDetailPenjualan.setMstBarang(mstBarang);
				String noNota = (rs.getString("NO_NOTA"));
				trHeaderPenjualan = trHeaderPenjualanDao.findOne(noNota);
				trDetailPenjualan.setTrHeaderPenjualan(trHeaderPenjualan);

				listTrDetailPenjualan.add(trDetailPenjualan);
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
		return listTrDetailPenjualan;
	}

}
