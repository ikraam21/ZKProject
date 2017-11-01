package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.MstCustomer;
import entity.MstKota;
import service.MstCustomerSvc;

public class MainCustomer {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstCustomerSvc mstCustomerSvc = ctx.getBean(MstCustomerSvc.class);
		
		MstCustomer mstCustomer = new MstCustomer();
		
		/*
		MstKota mstKota = new MstKota();
		mstKota.setKodeKota("K002");
		
		mstCustomer.setKodeCustomer("C002");
		mstCustomer.setNamaCustomer("Tri");
		mstCustomer.setAlamatCustomer("Jl. Sukasari");
		mstCustomer.setEmailCustomer("triap@gmail.com");
		mstCustomer.setJenisKelamin("PRIA");
		mstCustomer.setMstKota(mstKota);
		*/
		
		//save
		//mstCustomerSvc.save(mstCustomer);
		
		
		//update
		//mstCustomerSvc.update(mstCustomer);
		
		//delete
		mstCustomerSvc.delete("C003");
		
		//findone
		/*mstCustomer = mstCustomerSvc.findOne("C002");
		System.out.println("Data Customer: ");
		System.out.println("Kode: " + mstCustomer.getKodeCustomer());
		System.out.println("Nama: " + mstCustomer.getNamaCustomer());
		System.out.println("Alamar: " + mstCustomer.getAlamatCustomer());
		System.out.println("Jenis Kelamin: " + mstCustomer.getJenisKelamin());
		System.out.println("Email Customer: " + mstCustomer.getMstKota().getKodeKota());*/
		
	}

}
