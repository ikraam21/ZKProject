package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstCustomerSvc;
import service.MstKotaSvc;
import dao.MstKaryawanDao;
import dao.MstKotaDao;
import dao.MstProvinsiDao;
import entity.MstKaryawan;
import entity.MstKota;
import entity.MstProvinsi;

public class MainKota {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
//		MstKotaDao mstKotaDao = ctx.getBean(MstKotaDao.class);
//		MstKotaSvc mstKotaSvc = ctx.getBean(MstKotaSvc.class);
		
		MstCustomerSvc mstCustomerSvc = ctx.getBean(MstCustomerSvc.class);
		
		MstKota mstKota = new MstKota();
		/*MstProvinsi mstProvinsi = new MstProvinsi();
		mstProvinsi.setKodeProvinsi("P003");
		
		
		mstKota.setKodeKota("K007");
		mstKota.setNamaKota("Bogor");
		mstKota.setMstProvinsi(mstProvinsi);*/
		
		//save
		//mstKotaDao.save(mstKota);
		
		//delete
		//mstKotaDao.delete("K007");
		
		//update
		//mstKotaDao.update(mstKota);
		
		//findall
		/*List<MstKota> listKota = mstKotaDao.findAll();
		
		for(MstKota k : listKota){
			System.out.println("Data Kota: ");
			System.out.println("Kode Kota: " + k.getKodeKota());
			System.out.println("Nama: " + k.getNamaKota());
			System.out.println("Kode Provinsi: " + k.getMstProvinsi().getKodeProvinsi());
			System.out.println();
		}*/
		
		
		//findone
		/*mstKota = mstKotaDao.findOne("K007");
		System.out.println("Data Kota: ");
		System.out.println("Kode Kota: " + mstKota.getKodeKota());
		System.out.println("Nama Kota: " + mstKota.getNamaKota());
		System.out.println("Kode Provinsi: " + mstKota.getMstProvinsi().getKodeProvinsi());*/
		
		
		//findKotaProv
		List<MstKota> listKota = mstCustomerSvc.findByProv("P002");
				
		for(MstKota k : listKota){
			System.out.println("Data Kota: ");
			System.out.println("Kode Kota: " + k.getKodeKota());
	     	System.out.println("Nama: " + k.getNamaKota());
			System.out.println();
		}
	}

}
