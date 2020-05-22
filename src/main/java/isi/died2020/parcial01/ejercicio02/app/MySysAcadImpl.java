package isi.died2020.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import isi.died2020.parcial01.ejercicio02.Excepciones.InscribirAlumnoException;
import isi.died2020.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died2020.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died2020.parcial01.ejercicio02.dominio.*;
import isi.died2020.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(insc);
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) throws InscribirAlumnoException {
		for (Materia mat : m.getCorrelativasRendir()) {
			for (Examen exam : a.getExamenes()) {
				if(exam.getMateria()==m && exam.getNota()<6) {
					throw new InscribirAlumnoException("Error al inscribirse");
				}
			}
		}
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		
		// DESCOMENTAR Y gestionar excepcion
		 try {
			DB.guardar(e);
		} catch (BaseDeDatosExcepcion e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota>6) {
			Alumno a = e.getAlumno();
			for (Inscripcion i : a.getMateriasCursadas()) {
				if(e.getMateria() == i.getMateria()) {
					i.setEstado(Estado.PROMOCIONADO);
				}
			}
		}
	}


	@Override
	public List<Materia> materiasAprobadas(Alumno m) {
		List<Materia> aux = m.getMateriasCursadas().stream()
									.filter(mat -> mat.getEstado()==Estado.PROMOCIONADO)
									.map(mat -> mat.getMateria())
									.collect(Collectors.toList());
		
		return aux;
	}
	
	
	

}
