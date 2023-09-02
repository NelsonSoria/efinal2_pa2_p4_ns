package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository iMateriaRepository;
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Materia materia) {
		this.iMateriaRepository.insertar(materia);
		
	}

}
