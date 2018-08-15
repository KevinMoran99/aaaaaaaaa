package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javabeans.VentaBean;
import javabeans.LineaBean;

public class Operaciones {
	
	public Connection getConnection() { 
		Connection cn = null; 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			// cambiar por mis parametros
			cn = DriverManager.getConnection("jdbc:mysql://localhost/inventario", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return cn; 
	}
	
	public ArrayList<LineaBean> getLineas () { 
		Connection cn = null; 
		ArrayList<LineaBean> linea = null; 
		Statement st; 
		ResultSet rs; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "select * from lineas_de_venta"; 
			rs = st.executeQuery(tsql); 
			linea = new ArrayList<LineaBean>(); 
			while(rs.next()) { 
				LineaBean l = new LineaBean(
						rs.getInt("id_linea"), 
						rs.getString("Linea")
						); 
				linea.add(l); 
			} 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
		return(linea); 
	} 
	
	public LineaBean getLinea (int id_linea) { 
		Connection cn = null; 
		LineaBean linea = null; 
		Statement st; 
		ResultSet rs; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "select * from lineas_de_venta where id_linea = " + id_linea; 
			rs = st.executeQuery(tsql); 
			while(rs.next()) { 
				linea = new LineaBean(
						rs.getInt("id_linea"), 
						rs.getString("Linea")
						);  
			} 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
		return(linea); 
	} 
	
	public ArrayList<VentaBean> getVentas () { 
		Connection cn = null; 
		ArrayList<VentaBean> venta = null; 
		Statement st; 
		ResultSet rs; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "select * from ventas"; 
			rs = st.executeQuery(tsql); 
			venta = new ArrayList<VentaBean>(); 
			while(rs.next()) { 
				VentaBean m = new VentaBean(
						rs.getInt("id_venta"),
						rs.getInt("id_linea"), 
						rs.getDate("fecha_venta"),
						rs.getString("descripcion")
						); 
				venta.add(m); 
			} 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
		return(venta); 
	} 
	
	public VentaBean getVenta (int id_venta) { 
		Connection cn = null; 
		VentaBean venta = null; 
		Statement st; 
		ResultSet rs; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "select * from ventas where id_venta = " + id_venta; 
			rs = st.executeQuery(tsql); 
			while(rs.next()) { 
				venta = new VentaBean(
						rs.getInt("id_venta"),
						rs.getInt("id_linea"), 
						rs.getDate("fecha_venta"),
						rs.getString("descripcion")
						); 
			} 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
		return(venta); 
	} 
	
	public void addVentas (VentaBean v) { 
		Connection cn = null; 
		Statement st; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "insert into ventas values(null,"; 
			tsql += v.getId_linea() + ",NOW(),'" + v.getDescripcion() + "')";
			
			st.execute(tsql); 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	} 
	
	public void updateVentas (VentaBean v) {
		Connection cn = null; 
		Statement st; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "update ventas set id_linea = " + v.getId_linea() + ", descripcion = '" + v.getDescripcion() + "' where id_venta = " + v.getId_venta();
			
			st.executeUpdate(tsql); 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	}
	
	public void deleteVentas (int id_venta) {
		Connection cn = null; 
		Statement st; 
		try { 
			cn = getConnection(); 
			st = cn.createStatement(); 
			String tsql; 
			tsql= "delete from ventas where id_venta = " + id_venta;
			
			st.executeUpdate(tsql); 
			cn.close(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	}
}
