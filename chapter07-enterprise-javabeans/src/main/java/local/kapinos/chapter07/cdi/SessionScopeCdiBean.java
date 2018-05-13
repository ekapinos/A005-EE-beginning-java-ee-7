package local.kapinos.chapter07.cdi;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import local.kapinos.chapter07.ejb.StatefulSessionBean;
import local.kapinos.chapter07.ejb.StatelessSessionBean;

@SessionScoped
@SuppressWarnings("serial")
public class SessionScopeCdiBean implements Serializable {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	StatelessSessionBean statelessSessionBean;

	@Inject
	StatefulSessionBean statefulSessionBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this); 
	}

	public String callBean(boolean stateless, boolean stateful) {
		logger.info("Call for " + this);
		
		String res = "N/A";
		if(stateless)
		{
			res = statelessSessionBean.callBean();
		}
		else if(stateful)
		{
			res = statefulSessionBean.callBean();
		}
		
		return res;
	}

}
