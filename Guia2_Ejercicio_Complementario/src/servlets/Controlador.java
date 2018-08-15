package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.VentaBean;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	    response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    try { 
	    	String op = request.getParameter("operacion"); 
	    	
	    	if(op.equals("formAdd")) {
	    		Operaciones oper= new Operaciones(); 
	    		ArrayList lineas = oper.getLineas(); 
	    		request.setAttribute("lineas", lineas); 
	    		RequestDispatcher rd = request.getRequestDispatcher("/formAdd.jsp"); 
	    		rd.forward(request,response); 
	    	}
	    	if(op.equals("formUpdate")) {
	    		Operaciones oper= new Operaciones(); 
	    		ArrayList lineas = oper.getLineas(); 
	    		request.setAttribute("lineas", lineas);
	    		
	    		VentaBean venta = oper.getVenta(Integer.parseInt(request.getParameter("id")));
	    		request.setAttribute("venta", venta);

	    		RequestDispatcher rd = request.getRequestDispatcher("/formUpdate.jsp"); 
	    		rd.forward(request,response); 
	    	}
	    	
	    	if(op.equals("opAdd")) { 
	    		VentaBean ven = (VentaBean) request.getAttribute("venta"); 
	    		Operaciones oper = new Operaciones(); 
	    		oper.addVentas(ven); 
	    		response.sendRedirect("index.jsp"); 
	    	}

	    	if(op.equals("opUpdate")) { 
	    		VentaBean ven = (VentaBean) request.getAttribute("venta"); 
	    		Operaciones oper = new Operaciones(); 
	    		oper.updateVentas(ven); 
	    		response.sendRedirect("index.jsp"); 
	    	}

	    	if(op.equals("opDelete")) { 
	    		Operaciones oper = new Operaciones(); 
	    		oper.deleteVentas(Integer.parseInt(request.getParameter("id"))); 
	    		response.sendRedirect("index.jsp"); 
	    	}
	    	
	    } 
	    finally { 
	    out.close(); 
	    } 
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
