package com.eduardo.backendproject.controllers.dto;

public class MessageDto {

	private Long id;
	private String contenido;
	
	
	public MessageDto() {
		super();
	}
	
	
	public MessageDto(Long id, String contenido) {
		super();
		this.id = id;
		this.contenido = contenido;
	}



	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getContenido() {
		return contenido;
	}



	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
	
}
	
	
