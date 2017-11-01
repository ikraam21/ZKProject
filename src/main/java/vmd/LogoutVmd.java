package vmd;

import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class LogoutVmd implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Command("logout")
	public void logout(){
		Sessions.getCurrent().removeAttribute("user");
		Executions.getCurrent().sendRedirect("/login.zul");
	}
}
