package com.dto;

import com.entities.CarreraEspecialidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {
	private long idEstudiante;
	
	private CarreraEspecialidad carreraEspecialidad;
	
	private int idEstudiantil;
}
