package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorId(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(matricula);
		
	}

	@Override
	public List<MatriculaDTO> seleccionarTodos() {
		TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(
				"Select New com.example.demo.repository.modelo.dto.MatriculaDTO(e.cedula,ma.codigo,m.fechaMatricula,m.nombreHilo)"
				+ "   From Matricula m "
				+ "  JOIN m.estudiante e "
				+ "  JOIN m.materia ma",
				MatriculaDTO.class);
		return query.getResultList();
	}

}
