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
public class CarreraEspecialidad {
	private long idCarreraEspecialidad;
	
	private String nombre;
	
	private Departamento departamento;
}
