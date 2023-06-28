package com.vista;

import java.io.File;
import java.io.IOException;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import org.apache.commons.io.FileUtils;

@Named(value="claseDePrueba2")

@SessionScoped
public class claseDePrueba{
	
	public void funcion_Registrarse() {
		String cssFilePath = "estilos_Login_Registro.css"; // Ruta donde se encuentra el archivo CSS
		System.out.println("Estilos cambiados exitosamente.");
		try {
			File cssFile = new File(cssFilePath);
			String cssContent = FileUtils.readFileToString(cssFile, "UTF-8");

			cssContent = cssContent.replace(
					".formulario__login {\r\n" + "	opacity: 1;\r\n" + "	display: block;\r\n" + "}\r\n" + "\r\n"
							+ ".formulario__register {\r\n" + "	display: none;\r\n" + "	\r\n"
							+ "	/*Barra de scroll*/\r\n" + "	height: 432px;\r\n" + "	overflow-y: scroll;\r\n"
							+ "	overflow-x: hidden;\r\n" + "}",
					".formulario__login {\r\n" + "	opacity: 1;\r\n" + "	display: none;\r\n" + "}\r\n" + "\r\n"
							+ ".formulario__register {\r\n" + "	display: block;\r\n" + "	\r\n"
							+ "	/*Barra de scroll*/\r\n" + "	height: 432px;\r\n" + "	overflow-y: scroll;\r\n"
							+ "	overflow-x: hidden;\r\n" + "}");
			
			
			
			

			FileUtils.writeStringToFile(cssFile, cssContent, "UTF-8");

			System.out.println("Estilos cambiados exitosamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void funcion_IniciarSesion() {
		String cssFilePath = "estilos_Login_Registro.css"; // Ruta donde se encuentra el archivo CSS
		System.out.println("Estilos cambiados exitosamente.");
		try {
			File cssFile = new File(cssFilePath);
			String cssContent = FileUtils.readFileToString(cssFile, "UTF-8");

			cssContent = cssContent.replace(
					".formulario__login {\r\n" + "	opacity: 1;\r\n" + "	display: none;\r\n" + "}\r\n" + "\r\n"
							+ ".formulario__register {\r\n" + "	display: block;\r\n" + "	\r\n"
							+ "	/*Barra de scroll*/\r\n" + "	height: 432px;\r\n" + "	overflow-y: scroll;\r\n"
							+ "	overflow-x: hidden;\r\n" + "}",
					".formulario__login {\r\n" + "	opacity: 1;\r\n" + "	display: block;\r\n" + "}\r\n" + "\r\n"
							+ ".formulario__register {\r\n" + "	display: none;\r\n" + "	\r\n"
							+ "	/*Barra de scroll*/\r\n" + "	height: 432px;\r\n" + "	overflow-y: scroll;\r\n"
							+ "	overflow-x: hidden;\r\n" + "}");

			
			
			FileUtils.writeStringToFile(cssFile, cssContent, "UTF-8");

			System.out.println("Estilos cambiados exitosamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String prueba() {
		System.out.println("Estilos cambiados exitosamente.");
		return "";
	}
	
}
