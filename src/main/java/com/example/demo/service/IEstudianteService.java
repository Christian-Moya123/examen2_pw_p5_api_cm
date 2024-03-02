package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.to.EstudainteTO;


public interface IEstudianteService {
	public void inscripcionEstudiante(EstudainteTO estudiante);
	public List<EstudainteTO> buscarTodosEstudiante();

}
