package com.eduardo.backendproject.controllers.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class ImagesDto {
	
	private Long id;
	private String titulo;
	private byte[] content;
	
	
	public ImagesDto() {
		super();
	}
	
	
	public ImagesDto(Long id, String titulo, byte[] content) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.content = content;
	}


	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}
	
	

}
