package tn.esprit.gl1.mini_shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.gl1.mini_shop.persistence.Product;
import tn.esprit.gl1.mini_shop.services.CatalogServiceLocal;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/dispatcher")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		String userName = request.getParameter("nUser");
		String productName = request.getParameter("nProduct");

		PrintWriter printWriter = response.getWriter();

		Product product = new Product(productName, 100D, 10);

		catalogServiceLocal.createProduct(product);

		printWriter.write("<html><body>hello it is " + date
				+ " welcome Mr/Ms :" + userName
				+ " your product is ready </body></html>");
	}
}
