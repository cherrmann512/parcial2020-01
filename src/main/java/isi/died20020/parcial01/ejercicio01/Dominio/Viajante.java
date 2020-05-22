package isi.died20020.parcial01.ejercicio01.Dominio;

import java.util.List;

import isi.died20020.parcial01.ejercicio01.Dominio.Venta.Tipo;

public class Viajante extends Empleado {
	
	private List<Gasto> gastos;
	private List<Venta> ventas;
	
	
	
	
	@Override
	public double salario(int mes) {
		double salario = this.sueldoBasico;
		for (Venta v : ventas) {
			if(v.getTipo() == Tipo.AGROQUIMICO)
				salario= salario + v.getTotalVenta()*0.15;
			else salario= salario + v.getTotalVenta()*0.25;
		}
		if(this.fechaIngreso.getMonthValue() == mes) {
			salario= salario*1.5;
		}
		return salario;
	}
	
	public double getTotalVentas(){
		double totalVentas=0.0;
		for (Venta v : ventas) {
			totalVentas = totalVentas + v.getTotalVenta();
		}
		return totalVentas;
	}
	


}
