package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MstKaryawanSvc;
import dao.MstKaryawanDao;
import entity.MstKaryawan;

public class MainKaryawan {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		//MstKaryawanDao mstKaryawanDao = ctx.getBean(MstKaryawanDao.class);
		MstKaryawanSvc mstKaryawanSvc = ctx.getBean(MstKaryawanSvc.class);
		
		MstKaryawan mstKaryawan = new MstKaryawan();
		/*mstKaryawan.setKodeKaryawan("k002");
		mstKaryawan.setNamaKaryawan("Ananda");
		mstKaryawan.setUsername("AnandaTP");
		mstKaryawan.setPassword("ATP");*/
		
		
		//save
		//mstKaryawanDao.save(mstKaryawan);
		
		//delete
		//mstKaryawanDao.delete(mstKaryawan);
		
		//update
		//mstKaryawanDao.update(mstKaryawan);
		
		//findall
		//List<MstKaryawan> listKaryawan = mstKaryawanDao.findAll();
		/*List<MstKaryawan> listKaryawan = mstKaryawanSvc.findAllData();
		
		for(MstKaryawan k : listKaryawan){
			System.out.println("Data Karyawan: ");
			System.out.println("Kode: " + k.getKodeKaryawan());
			System.out.println("Nama: " + k.getNamaKaryawan());
			System.out.println("Username: " + k.getUsername());
			System.out.println("Password: " + k.getPassword());
		}*/
		
		
		//findone
		//mstKaryawan = mstKaryawanDao.findOne("K003");
		mstKaryawan = mstKaryawanSvc.findOne("K003");
		System.out.println("Data Karyawan: ");
		System.out.println("Kode: " + mstKaryawan.getKodeKaryawan());
		System.out.println("Nama: " + mstKaryawan.getNamaKaryawan());
		System.out.println("Username: " + mstKaryawan.getUsername());
		System.out.println("Password: " + mstKaryawan.getPassword());
	}

}
