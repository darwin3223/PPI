package com.entities;

import com.enums.EstadoItr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Itr {
	private long idItr;
	
	private String nombre;
	
	private String departamento;
	
	private String localidad;
	
	private EstadoItr estadoItr;
}
