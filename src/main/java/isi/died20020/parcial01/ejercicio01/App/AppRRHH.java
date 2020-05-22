package isi.died20020.parcial01.ejercicio01.App;

import java.util.ArrayList;
import java.util.List;

import isi.died20020.parcial01.ejercicio01.Dominio.Empleado;
import isi.died20020.parcial01.ejercicio01.Dominio.ReciboSueldo;;


public class AppRRHH {
	
	List<ReciboSueldo> recibos;
	
	public List<ReciboSueldo> facturar(List<Empleado> empleados, int mes){
		List<ReciboSueldo> recibos = new ArrayList<ReciboSueldo>();
		
		for (Empleado e : empleados) {
			ReciboSueldo r = new ReciboSueldo();
			r.setMes(mes);
			r.setSueldo(e.salario(mes));
			recibos.add(r);
		}
		
		return recibos;
	}
	

}
