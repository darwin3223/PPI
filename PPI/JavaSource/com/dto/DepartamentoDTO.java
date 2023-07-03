package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDTO {
	private long idDepartamento;
	
	private String nombre;
	
	private String localidad;
}
