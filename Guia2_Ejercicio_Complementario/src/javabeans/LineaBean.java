package javabeans;

public class LineaBean {
	private int id_linea;
	private String Linea;
	
	public LineaBean() {
	}

	public LineaBean(int id_linea, String linea) {
		this.id_linea = id_linea;
		Linea = linea;
	}

	public int getId_linea() {
		return id_linea;
	}

	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}

	public String getLinea() {
		return Linea;
	}

	public void setLinea(String linea) {
		Linea = linea;
	}
	
	
}
