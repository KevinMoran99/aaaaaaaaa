package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.MensajeBean;

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
	    out.println("Hola Mundo"); 
	    try { 
	    	String op = request.getParameter("operacion"); 
	    	if(op.equals("envio")) { 
	    		response.sendRedirect("envio.jsp"); 
	    	} 
	    	if(op.equals("grabar")) { 
	    		MensajeBean men = (MensajeBean) request.getAttribute("mensa"); 
	    		Operaciones oper = new Operaciones(); 
	    		oper.grabaMensaje(men); 
	    		response.sendRedirect("inicio.html"); 
	    	} 
	    	if(op.equals("muestra")) { 
	    		response.sendRedirect("mostrar.html"); 
	    	} 
	    	if(op.equals("ver")) { 
	    		Operaciones oper= new Operaciones(); 
	    		ArrayList mensajes = oper.obtenerMensajes(request.getParameter("nombre")); 
	    		request.setAttribute("mensajes", mensajes); 
	    		RequestDispatcher rd = request.getRequestDispatcher("/ver.jsp"); 
	    		rd.forward(request,response); 
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
