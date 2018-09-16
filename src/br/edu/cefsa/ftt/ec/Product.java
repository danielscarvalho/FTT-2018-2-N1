package br.edu.cefsa.ftt.ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet(description = "Product REST/JSON Service", urlPatterns = { "/product" })
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ProductBean> productData = new ArrayList<ProductBean>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException {
        
		System.out.println(new java.util.Date() + " GET..."); //Debug...
		
        request.setAttribute("produtosDados", this.productData);

        //Redirecionando para a página...
        RequestDispatcher rd = request.getRequestDispatcher("product_list.jsp");
		rd.forward(request, response);
		
	} //doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductBean prod = new ProductBean(
				request.getParameter("pid"),
				request.getParameter("pdescription"),
				request.getParameter("pvalue")
				);
		
		System.out.println(new java.util.Date() + " POST: " + prod); //Debug...
		
		this.productData.add(prod);
		
		System.out.println(this.productData.size());
		
		this.doGet(request, response); //Redireciona para a lista...
		
	} //doPost

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, 
			                HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductBean deleteProduct = new ProductBean(request.getParameter("pid"));
		
		System.out.println(new java.util.Date() + " DELETE: " + deleteProduct); //Debug...
		
		this.productData.remove(deleteProduct);
		
		this.doGet(request, response); //Redireciona para a lista...
		
	} //doDelete

}
