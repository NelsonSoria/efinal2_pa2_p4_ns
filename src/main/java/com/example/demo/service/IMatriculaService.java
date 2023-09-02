package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {

		public void matricular(String cedula
				, String codMat1,String codMat2,
				String codMat3,String codMat4);
		public List<MatriculaDTO> reporte();
}
