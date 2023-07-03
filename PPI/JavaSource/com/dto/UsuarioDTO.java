package com.dto;

import java.util.Date;

import com.entities.Itr;
import com.entities.Usuario;
import com.enums.TipoUsuario;
import com.enums.Verificacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	private long idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private int documento;
	
	private Date fechaNacimiento;
	
	private String direccion;
	
	private String nombreUsuario;
	
	private String contrasenia;
	
	private TipoUsuario tipoUsuario;
	
	private Verificacion verificacion;
	
	private String mail;
	
	private String telefono;
	
	private Itr itr;
}
