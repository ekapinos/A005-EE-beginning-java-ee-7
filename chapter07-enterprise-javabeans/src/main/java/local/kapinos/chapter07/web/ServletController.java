package local.kapinos.chapter07.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.kapinos.chapter07.ejb.StatefulSessionBean;
import local.kapinos.chapter07.ejb.StatelessSessionBean;

@WebServlet(urlPatterns = "/servlet/*")
@SuppressWarnings("serial")
public class ServletController extends HttpServlet {
	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	StatelessSessionBean statelessSessionBean;

	@Inject
	StatefulSessionBean statefulSessionBean;

	@PostConstruct
	public void postConstruct() {
		logger.warning("@PostConstruct for " + this); 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet() for " + this);
		resp.getWriter().append("See log " + this);
		
		if(req.getRequestURI().endsWith("/stateless"))
		{
			statelessSessionBean.callBean();
		}
		if(req.getRequestURI().endsWith("/stateful"))
		{
			statefulSessionBean.callBean();
		}
	}
}
