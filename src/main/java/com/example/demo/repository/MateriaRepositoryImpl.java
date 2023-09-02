package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
		
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> query= this.entityManager.createQuery("Select m From Materia m Where m.codigo=:DatoCodigo",Materia.class);
		query.setParameter("DatoCodigo", codigo);
		return query.getSingleResult();
	}

}
