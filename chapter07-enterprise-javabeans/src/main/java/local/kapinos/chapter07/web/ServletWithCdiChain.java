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

import local.kapinos.chapter07.cdi.CdiChain03;


@WebServlet(urlPatterns = "/webservlet-cdi-chain")
@SuppressWarnings("serial")
public class ServletWithCdiChain extends HttpServlet {

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	CdiChain03 chain;

	@PostConstruct
	public void postConstruct() {
		logger.info("@PostConstruct for " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Call for " + this);
		resp.getWriter().append("See log " + this);

		chain.call();
	}
}
