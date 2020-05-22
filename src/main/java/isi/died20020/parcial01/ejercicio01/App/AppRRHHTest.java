package isi.died20020.parcial01.ejercicio01.App;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import isi.died20020.parcial01.ejercicio01.Dominio.Empleado;
import isi.died20020.parcial01.ejercicio01.Dominio.Operario;
import isi.died20020.parcial01.ejercicio01.Dominio.Viajante;

public class AppRRHHTest {

	@Test
	public void testFacturar() {
		AppRRHH a1 = new AppRRHH();
		Viajante v1 = new Viajante();
		Operario o1 = new Operario();
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		listaEmpleado.add(o1);
		listaEmpleado.add(v1);
		
		
		
		
	}

}
