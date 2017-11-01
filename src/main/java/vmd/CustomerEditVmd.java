package vmd;

import java.util.ArrayList;
import java.util.List;

import entity.MstCustomer;
import entity.MstKota;
import entity.MstProvinsi;

import org.w3c.dom.ls.LSInput;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

import service.MstCustomerSvc;
import service.MstKotaSvc;
import service.MstProvinsiSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CustomerEditVmd {
	private List<MstKota> listKota = new ArrayList<>();
	private List<MstProvinsi> listProvinsi = new ArrayList<>();
	private MstCustomer mstCustomer = new MstCustomer();
	private MstProvinsi mstProvinsi;
	private MstKota mstKota;
	
	@WireVariable
	private MstCustomerSvc mstCustomerSvc;
	
	@WireVariable
	private MstProvinsiSvc mstProvinsiSvc;
	
	@WireVariable
	private MstKotaSvc mstKotaSvc;
	

	@Init
	public void load(){
		mstCustomer = (MstCustomer) Sessions.getCurrent().getAttribute("obj");
		if (mstCustomer.getKodeCustomer() != null) {
			String kodeKota = mstCustomer.getMstKota().getKodeKota();
			listProvinsi = mstProvinsiSvc.findAllData();
			listKota = mstKotaSvc.findAllData();
			mstKota = mstKotaSvc.findOne(kodeKota);
			mstProvinsi = mstKota.getMstProvinsi();
		}else {
			listKota = mstKotaSvc.findAllData();
			listProvinsi = mstProvinsiSvc.findAllData();
		}
	}
	
	@Command("save")
	public void save(){
		MstCustomer mstCustomerfindone = new MstCustomer();
		mstCustomerfindone = mstCustomerSvc.findOne(mstCustomer.getKodeCustomer());
		
		if (mstCustomerfindone.getKodeCustomer() == null) {
			mstCustomerSvc.save(mstCustomer);
			Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("master/customer/customer.zul");
			//Executions.sendRedirect("customer.zul");
		} else if(mstCustomerfindone.getKodeCustomer() != null) {
			mstCustomerSvc.update(mstCustomer);
			Clients.showNotification("Data berhasil diupdate", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("master/customer/customer.zul");
			//Executions.sendRedirect("customer.zul");
		}
	}
	
	@Command("back")
	public void back(){
		Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
		inc.setSrc("master/customer/customer.zul");
		//Executions.sendRedirect("customer.zul");
	}
	
	@Command("findkota")
	@NotifyChange({"listKota", "mstKota"})
	public void findKota(){
		mstKota = null;
		String kode = mstProvinsi.getKodeProvinsi();
		listKota = mstCustomerSvc.findByProv(kode);
	}

	public List<MstKota> getListKota() {
		return listKota;
	}

	public void setListKota(List<MstKota> listKota) {
		this.listKota = listKota;
	}

	public List<MstProvinsi> getListProvinsi() {
		return listProvinsi;
	}

	public void setListProvinsi(List<MstProvinsi> listProvinsi) {
		this.listProvinsi = listProvinsi;
	}

	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}

	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}

	public MstProvinsi getMstProvinsi() {
		return mstProvinsi;
	}

	public void setMstProvinsi(MstProvinsi mstProvinsi) {
		this.mstProvinsi = mstProvinsi;
	}

	public MstKota getMstKota() {
		return mstKota;
	}

	public void setMstKota(MstKota mstKota) {
		this.mstKota = mstKota;
	}
	
	
}
