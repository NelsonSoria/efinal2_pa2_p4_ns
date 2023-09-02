package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("Select e From Estudiante e Where e.cedula=:DatoCedula",Estudiante.class);
		query.setParameter("DatoCedula", cedula);
		return query.getSingleResult();
	}

}
