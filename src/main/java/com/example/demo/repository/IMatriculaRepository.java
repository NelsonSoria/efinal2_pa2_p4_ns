package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {

	
	public void insertar(Matricula matricula );
	public void eliminar(Integer id);
	public Matricula seleccionarPorId(Integer id);
	public void actualizar(Matricula matricula);
	
	public List<MatriculaDTO> seleccionarTodos();
}
