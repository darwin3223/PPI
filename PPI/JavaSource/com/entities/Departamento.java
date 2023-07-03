package com.entities;

import java.util.Date;

import com.enums.TipoUsuario;
import com.enums.Verificacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
	private long idDepartamento;
	
	private String nombre;
	
	private String localidad;
}
