package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.to.EstudainteTO;
import com.example.demo.modeloo.Estudiante;
import com.example.demo.respository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianterepo;
	


	@Override
	public void inscripcionEstudiante(EstudainteTO estudiante) {
		// TODO Auto-generated method stub
		this.estudianterepo.insertarEstudiante(this.convertirTO(estudiante));
	}


	@Override
	public List<EstudainteTO> buscarTodosEstudiante() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianterepo.buscarTodosEstudiantes();
		List<EstudainteTO> listaTO = lista.stream().map(estudiante -> this.convertir(estudiante)).collect(Collectors.toList());
		return listaTO;
	}
	
	private EstudainteTO convertir(Estudiante estu) {
		EstudainteTO estuTO = new EstudainteTO();
		estuTO.setApellido(estu.getApellido());
		estuTO.setCedula(estu.getCedula());
		estuTO.setId(estu.getId());
		estuTO.setNombre(estu.getNombre());
		
		return estuTO;
	}
	
	
	private Estudiante convertirTO(EstudainteTO estuTO) {
			Estudiante estu = new Estudiante();
			estu.setApellido(estuTO.getApellido());
			estu.setCedula(estuTO.getCedula());
			estu.setId(estuTO.getId());
			estu.setNombre(estuTO.getNombre());
			
			return estu;
	}

}
