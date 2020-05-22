package isi.died20020.parcial01.ejercicio01.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Operario extends Empleado {
	
	private List<Viajante> atendidos = new ArrayList<Viajante>();

	
	
	@Override
	public double salario(int mes) {
		double salario = this.sueldoBasico;
		double ventasViajeros = 0.0;
		for (Viajante v : atendidos) {
			ventasViajeros = ventasViajeros + v.getTotalVentas()*0.2;
		}
		salario = salario + ventasViajeros;
		if(this.fechaIngreso.getMonthValue() == mes) {
			salario= salario*1.5;
		}
		return salario;
	}
	
	
	
	
	
}
