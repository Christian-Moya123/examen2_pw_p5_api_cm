package com.example.demo.respository;

import java.util.List;

import com.example.demo.modeloo.Estudiante;



public interface IEstudianteRepository {
	
	public void insertarEstudiante(Estudiante estudiante);
	public List<Estudiante> buscarTodosEstudiantes();

}
