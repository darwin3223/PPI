package com.services;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.beans.UsuarioBean;
import com.dto.UsuarioDTO;
import com.entities.Usuario;
import com.exception.ExceptionsTools;
import com.exception.PersistenciaException;

@Named(value = "usuarioService")
@SessionScoped
public class UsuarioService {
	@EJB
	UsuarioBean usuarioBean;
	
	private UsuarioDTO usuarioSeleccionado;
	private long idSeleccionada;
	
	private String nombreUsuarioLogin;
	private String contraseniaLogin;
	
	public String registrarUsuario() {
		Usuario usuarioNuevo;
		try {
			usuarioNuevo = dtoToUsuario(usuarioSeleccionado);
			usuarioBean.crear(usuarioNuevo);
			
			// mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se ha registrado el usuario: " + usuarioSeleccionado.getNombreUsuario() + " correctamente", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			usuarioSeleccionado = new UsuarioDTO();
			return "";

		} catch (Exception e) {

			Throwable rootException = ExceptionsTools.getCause(e);
			String msg1 = e.getMessage();
			String msg2 = ExceptionsTools.formatedMsg(rootException);

			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			e.printStackTrace();
		} finally {

		}
		return "";
	}
	
	public String modificarUsuario() {
		try {
			usuarioSeleccionado.setIdUsuario(idSeleccionada);
			usuarioBean.modificar(dtoToUsuario(usuarioSeleccionado));

			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se ha Modificado el usuario: " + usuarioSeleccionado.getNombreUsuario() + " correctamente", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			usuarioSeleccionado = new UsuarioDTO();
			return "";
		} catch (Exception e) {
			Throwable rootException = ExceptionsTools.getCause(e);
			String msg1 = e.getMessage();
			String msg2 = ExceptionsTools.formatedMsg(rootException);

			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

			e.printStackTrace();
			return "";
		}

	}
	
	public void borrarUsuario() {
		usuarioBean.borrar(idSeleccionada);
		
//		try {
//			usuarioBean.borrar(idSeleccionada);
//			refrescarListaUsuarios();
//		} catch (PersistenciaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public String login() throws PersistenciaException {
		String e = "";
		List<Usuario> usuarios = usuarioBean.obtenerTodos();
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNombreUsuario().equals(nombreUsuarioLogin)
					&& usuarios.get(i).getContrasenia().equals(contraseniaLogin)) {
				e = "Bienvenido.xhtml";
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, " ", null));
//				titulo = "Bienvenido " + usuarios.get(i).getNombre();
				break;
			}
		}
		if (!nombreUsuarioLogin.isEmpty() && !contraseniaLogin.isEmpty() && e == "") {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nombre de usuario o contraseña invalidos", null));
		} else if (contraseniaLogin.isEmpty() && nombreUsuarioLogin.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, Complete todos los campos.", null));
		} else if (nombreUsuarioLogin.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, El nombre de usuario es obligatorio.", null));
		} else if (contraseniaLogin.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, La contraseña es obligatoria.", null));
		}
		return e;
	}
	
	public Usuario dtoToUsuario(UsuarioDTO usuDTO) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuDTO.getIdUsuario());
		usuario.setNombre(usuDTO.getNombre());
		usuario.setApellido(usuDTO.getApellido());
		usuario.setDocumento(usuDTO.getDocumento());
		usuario.setFechaNacimiento(usuDTO.getFechaNacimiento());
		usuario.setDireccion(usuDTO.getDireccion());
		usuario.setNombreUsuario(usuDTO.getNombreUsuario());
		usuario.setContrasenia(usuDTO.getContrasenia());
		usuario.setTipoUsuario(usuDTO.getTipoUsuario());
		usuario.setVerificacion(usuDTO.getVerificacion());
		usuario.setMail(usuDTO.getMail());
		usuario.setTelefono(usuDTO.getTelefono());
		usuario.setItr(usuDTO.getItr());
		return usuario;
	}
	
	
	
	
	//GETTERS AND SETTERS
	public UsuarioDTO getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(UsuarioDTO usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public long getIdSeleccionada() {
		return idSeleccionada;
	}

	public void setIdSeleccionada(long idSeleccionada) {
		this.idSeleccionada = idSeleccionada;
	}
	
	
}
