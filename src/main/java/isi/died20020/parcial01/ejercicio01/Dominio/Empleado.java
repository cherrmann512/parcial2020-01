package isi.died20020.parcial01.ejercicio01.Dominio;

import java.time.LocalDate;

public abstract class Empleado {
	
	protected Integer cuil;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaIngreso;
	protected Double sueldoBasico;
	
	
	public abstract double salario(int mes);
	
	
}
