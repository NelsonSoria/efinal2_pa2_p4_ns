package com.example.demo.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	@GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_matricula",sequenceName ="seq_matricula",allocationSize = 1 )
	@Id
	@Column(name="matr_id")
	private Integer id;
	@Column(name="matr_fecha_matricula")
	private LocalDate fechaMatricula;
	
	@Column(name="matr_nombre_hilo")
	private String nombreHilo;
	
	@ManyToOne
	@JoinColumn(name="matr_mate_id")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name="matr_estu_id")
	private Estudiante estudiante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	
	
}
