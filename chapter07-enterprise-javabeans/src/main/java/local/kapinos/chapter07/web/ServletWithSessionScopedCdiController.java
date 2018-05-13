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

import local.kapinos.chapter07.cdi.SessionScopeCdiBean;

@WebServlet(urlPatterns = "/webservlet-sessionscoped/*")
@SuppressWarnings("serial")
public class ServletWithSessionScopedCdiController extends HttpServlet {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	SessionScopeCdiBean sessionScopedCdiBean;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Call for " + this);
		resp.getWriter().append("See log " + this);

		sessionScopedCdiBean.callBean(
				req.getRequestURI().endsWith("/stateless"),
				req.getRequestURI().endsWith("/stateful"));
	}
}
