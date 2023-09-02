package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	
	//http://localhost:8080/uce/matriculas/nuevo
		
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping("/nuevo")
	private String paginaNuevaMatricula(Matricula matricula) {
		return "vistaNuevaMatricula";
	}
	
	@PostMapping("/guardar")
	private String matricular(@RequestParam("cedula")String cedula
			,@RequestParam("codMat")String codMat1
			,@RequestParam("codMat2")String codMat2
			,@RequestParam("codMat3")String codMat3
			,@RequestParam("codMat4")String codMat4) {
		
		this.iMatriculaService.matricular(cedula, codMat1, codMat2, codMat3, codMat4);
		return "redirect:/matriculas/nuevo";
	}
	//http://localhost:8080/uce/matriculas/reporte
	
	@GetMapping("/reporte")
	private String reporte(Model model) {
		List<MatriculaDTO> list = this.iMatriculaService.reporte();
		model.addAttribute("matriculasdto",list);
		return "vistaListaMatricula";
		
	}
	
	
	


}
