package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.MstBarang;
import service.MstBarangSvc;

public class MainBarang {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstBarangSvc mstBarangSvc = ctx.getBean(MstBarangSvc.class);
		MstBarang mstBarang = new MstBarang();
		
		
		mstBarang.setKodeBarang("b44");
		mstBarang.setNamaBarang("rr");
		mstBarang.setStokBarang(50);
		
		
		
		//update
		mstBarangSvc.updateStok(mstBarang);
	}

}
