package tn.esprit.gl1.mini_shop;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/MyServlet")
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

		String prodName = request.getParameter("name");
		Double prodCost = Double.parseDouble(request.getParameter("cost"));

		Product product = new Product();
		product.setName(prodName);
		product.setUnitCost(prodCost);

		catalogServiceLocal.createProduct(product);

		List<Product> prods = catalogServiceLocal.findAllProducts();
		System.out.println("///: " + prods.size());
		request.setAttribute("prods", prods);

		RequestDispatcher rd = request
				.getRequestDispatcher("./jsp/product-list.jsp");
		rd.forward(request, response);

	}

}
