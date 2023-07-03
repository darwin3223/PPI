package com.dto;

import java.util.Date;

import com.entities.Itr;
import com.entities.Usuario;
import com.enums.EstadoItr;
import com.enums.TipoUsuario;
import com.enums.Verificacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItrDTO {
	private long idItr;
	
	private String nombre;
	
	private String departamento;
	
	private String localidad;
	
	private EstadoItr estadoItr;
}
