package isi.died20020.parcial01.ejercicio01.Dominio;

public class ReciboSueldo {
	
	
	private static Integer NUM_GENERATOR=0;
	private Integer numeroRecibo;
	private Integer mes;
	private Double sueldo;
	private Empleado empleado;
	
	
	public ReciboSueldo() {
		this.NUM_GENERATOR++;
		this.numeroRecibo = this.NUM_GENERATOR;
	}
	
	public void setNumeroRecibo(Integer numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
