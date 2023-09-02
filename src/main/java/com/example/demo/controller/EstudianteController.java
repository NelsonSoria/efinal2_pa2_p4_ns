package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	
	@Autowired
	private IEstudianteService estudianteService;
	
	
	
	//http://localhost:8080/uce/estudiantes/nuevo
	
	@GetMapping("/nuevo")
	private String paginaNuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}
	
	
	@PostMapping("/guardar")
	private String guardarEstudiante(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevo";
	}

}
