package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.MstProvinsiDao;
import entity.MstProvinsi;

public class MainProvinsi {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");

		MstProvinsiDao mstProvinsiDao = ctx.getBean(MstProvinsiDao.class);
		MstProvinsi mstProvinsi = new MstProvinsi();
		
		//mstProvinsi.setKodeProvinsi("P004");
		//mstProvinsi.setNamaProvinsi("JAWA TIMUR");
		
		//save
		//mstProvinsiDao.save(mstProvinsi);
		
		//delete
		//mstProvinsiDao.delete("P004");
		
		//update
		//mstProvinsiDao.update(mstProvinsi);
		
		//findall
		/*List<MstProvinsi> listProvinsi = mstProvinsiDao.findAll();
		
		for(MstProvinsi p : listProvinsi){
			System.out.println("Data Provinsi: ");
			System.out.println("Kode Provinsi: " + p.getKodeProvinsi());
			System.out.println("Nama Provinsi: " + p.getNamaProvinsi());
			System.out.println();
		}*/
		
		//findone
		/*mstProvinsi = mstProvinsiDao.findOne("P001");
		System.out.println("Data Provinsi: ");
		System.out.println("Kode Provinsi: " + mstProvinsi.getKodeProvinsi());
		System.out.println("Nama Provinsi: " + mstProvinsi.getNamaProvinsi());*/
	}

}
