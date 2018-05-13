package local.kapinos.chapter07.web;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.kapinos.chapter07.ejb.AsyncStatefulSessionBean;

@WebServlet(urlPatterns = "/webservlet-async")
@SuppressWarnings("serial")
public class ServletWithAsync extends HttpServlet {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	AsyncStatefulSessionBean syncStatelessSessionBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Call for " + this);
		resp.getWriter().append("See log " + this);

		Future<String> res = syncStatelessSessionBean.callBean();
		try {
			resp.getWriter().append("<br>" + res.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
