package vmd;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

public class AuthCheckerVmd implements Initiator{

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		Session sess = Sessions.getCurrent();
		
		if (!sess.hasAttribute("user")) {
			Executions.sendRedirect("/login.zul");
			return;
		}
	}
	
}
