package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void matricular(String cedula, String codMat1, String codMat2, String codMat3, String codMat4) {
		
	   Thread hilo = Thread.currentThread();
	   String nombreHilo = hilo.getName();

		Estudiante estudiante=this.estudianteRepository.seleccionarPorCedula(cedula);
		Materia materia1= this.iMateriaRepository.seleccionarPorCodigo(codMat1);
		Materia materia2= this.iMateriaRepository.seleccionarPorCodigo(codMat2);
		Materia materia3= this.iMateriaRepository.seleccionarPorCodigo(codMat3);
		Materia materia4= this.iMateriaRepository.seleccionarPorCodigo(codMat4);
		
		List<Materia> lista= new ArrayList<>();
		lista.add(materia1);
		lista.add(materia2);
		lista.add(materia3);
		lista.add(materia4);
		
		//List<Matricula> listaInsert= new ArrayList<>();
		
		for(Materia m: lista) {
			Matricula matricula = new Matricula();
			matricula.setEstudiante(estudiante);
			matricula.setFechaMatricula(LocalDate.now());
			matricula.setMateria(m);
			matricula.setNombreHilo(nombreHilo);
			//listaInsert.add(matricula);
		this.iMatriculaRepository.insertar(matricula);
		}
	
		// listaInsert.parallelStream().forEach(matri-> this.iMatriculaRepository.insertar(matri));
		 
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<MatriculaDTO> reporte() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionarTodos();
	}

	

}
