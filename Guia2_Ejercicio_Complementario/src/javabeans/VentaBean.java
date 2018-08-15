package javabeans;

import java.util.Date;

public class VentaBean {
	private int id_venta;
	private int id_linea;
	private Date fecha_venta;
	private String descripcion;
	
	public VentaBean() {
	}

	public VentaBean(int id_venta, int id_linea, Date fecha_venta, String descripcion) {
		this.id_venta = id_venta;
		this.id_linea = id_linea;
		this.fecha_venta = fecha_venta;
		this.descripcion = descripcion;
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public int getId_linea() {
		return id_linea;
	}

	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
