package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

public class MainTrHeaderPenjualan {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");

		TrHeaderPenjualanSvc trHeaderPenjualanSvc = ctx
				.getBean(TrHeaderPenjualanSvc.class);

		TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();

		 // delete
		 //trHeaderPenjualanSvc.deleteDetail("tescobagan");

		 // search
		 /*List<TrHeaderPenjualan> listHeader = trHeaderPenjualanSvc.searchData("tes");
		 for(TrHeaderPenjualan k : listHeader){
			 System.out.println("Data Header: ");
				System.out.println("No Nota: " + k.getNoNota());
				System.out.println("Tanggal Transaksi: " + k.getTanggalTransaksi());
				System.out.println("Harga Total: " + k.getHargaTotal());
				System.out.println("Global Diskon: " + k.getGlobalDiskon());
				System.out.println("Kode Customer: " + k.getMstCustomer().getKodeCustomer());
				System.out.println("Kode Karyawan: " + k.getMstKaryawan().getKodeKaryawan());
				System.out.println();
		 }*/
		 
		 
		 // findall
		 List<TrHeaderPenjualan> listHeader = trHeaderPenjualanSvc.findAllData();
		 for(TrHeaderPenjualan k : listHeader){
			 System.out.println("Data Header: ");
				System.out.println("No Nota: " + k.getNoNota());
				System.out.println("Tanggal Transaksi: " + k.getTanggalTransaksi());
				System.out.println("Harga Total: " + k.getHargaTotal());
				System.out.println("Global Diskon: " + k.getGlobalDiskon());
				System.out.println("Kode Customer: " + k.getMstCustomer().getKodeCustomer());
				System.out.println("Kode Karyawan: " + k.getMstKaryawan().getKodeKaryawan());
				System.out.println();
		 }
		 
		 
	}

}
