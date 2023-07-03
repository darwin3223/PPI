package com.dto;

import com.entities.Departamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraEspecialidadDTO {
	private long idCarreraEspecialidad;
	
	private String nombre;
	
	private Departamento departamento;
}
