package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import entity.TrHeaderPenjualan;
import service.TrHeaderPenjualanSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PenjualanVmd {

	@WireVariable
	private TrHeaderPenjualanSvc trHeaderPenjualanSvc;

	private TrHeaderPenjualan trHeaderPenjualan;
	private List<TrHeaderPenjualan> listHeader = new ArrayList<>();
	private String search;

	public TrHeaderPenjualan getTrHeaderPenjualan() {
		return trHeaderPenjualan;
	}

	public void setTrHeaderPenjualan(TrHeaderPenjualan trHeaderPenjualan) {
		this.trHeaderPenjualan = trHeaderPenjualan;
	}

	public List<TrHeaderPenjualan> getListHeader() {
		return listHeader;
	}

	public void setListHeader(List<TrHeaderPenjualan> listHeader) {
		this.listHeader = listHeader;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Init
	public void load() {
		listHeader = trHeaderPenjualanSvc.findAllData();
	}

	@Command("add")
	public void add() {
		TrHeaderPenjualan trHeaderPenjualan = new TrHeaderPenjualan();
		Sessions.getCurrent().setAttribute("header", trHeaderPenjualan);
		Executions.sendRedirect("/transaksi/penjualanedit.zul");
	}

	@Command("edit")
	@NotifyChange({ "includeSrc", "p" })
	public void edit() {
		if (trHeaderPenjualan == null) {
			Messagebox.show("Pilih data yang akan diedit!");
		} else {
			Sessions.getCurrent().setAttribute("header", trHeaderPenjualan);
			Executions.sendRedirect("/transaksi/penjualanedit.zul");
		}
	}

	@Command("delete")
	public void delete() {
		try{
		trHeaderPenjualanSvc.delete(trHeaderPenjualan.getNoNota());
		trHeaderPenjualanSvc.deleteDetail(trHeaderPenjualan.getNoNota());
		listHeader.remove(trHeaderPenjualan);
		BindUtils.postNotifyChange(null, null, PenjualanVmd.this, "listHeader");
		Clients.showNotification("Data berhasil di delete",
				Clients.NOTIFICATION_TYPE_INFO, null, null, 500);
		}catch(NullPointerException e){
			Messagebox.show("Pilih data yang akan diedit!");
		}
		
	}

	@Command("search")
	@NotifyChange("listHeader")
	public void search() {
		listHeader.clear();
		listHeader = trHeaderPenjualanSvc.searchData(search);
	}
}
