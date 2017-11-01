package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.TrDetailPenjualan;
import service.TrDetailPenjualanSvc;

public class MainTrDetailPenjualan {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		
		TrDetailPenjualanSvc trDetailPenjualanSvc = ctx.getBean(TrDetailPenjualanSvc.class);
		TrDetailPenjualan trDetailPenjualan = new TrDetailPenjualan();
		
		List<TrDetailPenjualan> listDetail = trDetailPenjualanSvc.findByHeader("TR001");
		for(TrDetailPenjualan k : listDetail){
			 System.out.println("Data Detail: ");
				System.out.println("Kode Detail: " + k.getKodeDetail());
				System.out.println("Qty: " + k.getQty());
				System.out.println("Subtotal: " + k.getSubTotal());
				System.out.println("Diskon: " + k.getDiskon());
				System.out.println("Harga Satuan: " + k.getHargaSatuan());
				System.out.println("Kode Barang: " + k.getMstBarang().getKodeBarang());
				System.out.println("No Nota: " + k.getTrHeaderPenjualan().getNoNota());
				System.out.println();
		 }
	}

}
