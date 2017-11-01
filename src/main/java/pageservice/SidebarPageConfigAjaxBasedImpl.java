package pageservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SidebarPageConfigAjaxBasedImpl implements SidebarPageConfig {
	
	HashMap<String,SidebarPage> pageMp = new LinkedHashMap<String,SidebarPage>();
	
	public SidebarPageConfigAjaxBasedImpl() {
		pageMp.put("fn1", new SidebarPage("Segitiga","/imgs/fn.png","/hitungLuasSegitiga.zul"));
		pageMp.put("fn2", new SidebarPage("Login","/imgs/fn.png","/login.zul"));
		pageMp.put("fn3", new SidebarPage("Customer","/imgs/fn.png","/master/customer/customer.zul"));
	}

	@Override
	public List<SidebarPage> getPage() {
		return new ArrayList<SidebarPage>(pageMp.values());
	}
	

}
