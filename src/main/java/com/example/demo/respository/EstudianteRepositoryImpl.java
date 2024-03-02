package com.example.demo.respository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modeloo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> buscarTodosEstudiantes() {
		// TODO Auto-generated method stub
		String sql ="SELECT e FROM Estudiante e";
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(sql, Estudiante.class);
		
		return myQuery.getResultList();
	}

}
