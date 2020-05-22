package isi.died20020.parcial01.ejercicio01.Dominio;

import java.time.LocalDate;

public class Venta {
	
	public enum Tipo {AGROQUIMICO, VETERINARIO};
	
	private LocalDate fechaVenta;
	private Double totalVenta;
	private Tipo tipo;
	
	
	public Double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	

}
