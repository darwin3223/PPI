package com.vista;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JOptionPane;

import com.entities.Usuario;

import lombok.val;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;

@Named(value = "gestionUsuarios")
@SessionScoped
public class GestionUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreUsuarioLogin = null;
	private String contraseniaLogin = null;
	private String mensajeErrorLogin = null;
	private String mensajeErrorRegistro = null;
	private List<Usuario> listaUsuarios;
	private String titulo;
	private long idSeleccionada;

	@PostConstruct
	public void init() {
	}

	public long getIdSeleccionada() {
		return idSeleccionada;
	}

	public void setIdSeleccionada(long idSeleccionada) {
		this.idSeleccionada = idSeleccionada;
	}

	public String getNombreUsuarioLogin() {
		return nombreUsuarioLogin;
	}

	public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
		this.nombreUsuarioLogin = nombreUsuarioLogin;
	}

	public String getContraseniaLogin() {
		return contraseniaLogin;
	}

	public void setContraseniaLogin(String contraseniaLogin) {
		this.contraseniaLogin = contraseniaLogin;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensajeErrorLogin() {
		return mensajeErrorLogin;
	}

	public void setMensajeErrorLogin(String mensajeErrorLogin) {
		this.mensajeErrorLogin = mensajeErrorLogin;
	}

	public String getMensajeErrorRegistro() {
		return mensajeErrorRegistro;
	}

	public void setMensajeErrorRegistro(String mensajeErrorRegistro) {
		this.mensajeErrorRegistro = mensajeErrorRegistro;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
