package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javabeans.MensajeBean;

public class Operaciones {
	
	public Connection getConnection() { 
		Connection cn = null; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			// cambiar por mis parametros
			cn = DriverManager.getConnection("jdbc:mysql://localhost/mensaje", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return cn; 
	}
	
	public ArrayList<MensajeBean> obtenerMensajes (String destino) { 
		Connection cn = null; 
		ArrayList<MensajeBean> mensaje = null; 
		Statement st; 
		ResultSet rs; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "select * from mensajes where destinatario='" + destino + "'"; 
			rs = st.executeQuery(tsql); 
			mensaje = new ArrayList<MensajeBean>(); 
			while(rs.next()) { 
				MensajeBean m = new MensajeBean(
						rs.getString("remitente"),
						rs.getString("destinatario"), 
						rs.getString("texto")
						); 
				mensaje.add(m); 
			} 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
		return(mensaje); 
	} 
	
	public void grabaMensaje (MensajeBean m) { 
		Connection cn = null; 
		Statement st; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "insert into mensajes values(null,'"; 
			tsql += m.getRemite() + "','" + m.getDestino() + "','" + m.getTexto() + "')";
			
			st.execute(tsql); 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}
