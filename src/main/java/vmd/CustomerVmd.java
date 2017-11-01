package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

import entity.MstCustomer;
import pagevmd.NavigationVmd;
import service.MstCustomerSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CustomerVmd extends NavigationVmd{
	private List<MstCustomer> listCustomer = new ArrayList<>();
	private MstCustomer mstCustomer = new MstCustomer();
	private boolean readonly = false;
	
	@WireVariable
	private MstCustomerSvc mstCustomerSvc;

	public List<MstCustomer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<MstCustomer> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}

	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	
	
	@Init
	public void load(){
		listCustomer = mstCustomerSvc.findAllData();
	}
	
	@Command("add")
	public void add(){
		MstCustomer mstCustomer = new MstCustomer();
		Sessions.getCurrent().setAttribute("obj", mstCustomer);
		Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
		inc.setSrc("master/customer/customerEdit.zul");
		//Executions.sendRedirect("customerEdit.zul");
	}
	
	@Command("edit")
	public void edit(){
		if (mstCustomer.getKodeCustomer() == null ) {
			Messagebox.show("Pilih data yang akan diedit!");
		}else {
			Sessions.getCurrent().setAttribute("obj", mstCustomer);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("master/customer/customerEdit.zul");
			//Executions.sendRedirect("customerEdit.zul");
		}
	}
	
	@Command("delete")
	public void delete(){
		if (mstCustomer.getKodeCustomer() == null) {
			Messagebox.show("Pilih data yang akan didelete!");
		}else {
			mstCustomerSvc.delete(mstCustomer.getKodeCustomer());
			listCustomer.remove(mstCustomer);
			BindUtils.postNotifyChange(null, null, CustomerVmd.this, "listCustomer");
			Clients.showNotification("Data berhasil didelete", Clients.NOTIFICATION_TYPE_INFO, null, null, 500);
		}
	}
	
}
