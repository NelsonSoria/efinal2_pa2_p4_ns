package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	// http://localhost:8080/uce/materias/nuevo

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping("/nuevo")
	private String paginaNuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping("/guardar")
	private String guardarEstudiante(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/nuevo";
	}

}
