package com.william.cloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="car")
public class Car {

	@Id
	private String id;
	private String nome;
	private String placa;
	private String imageUrl;
	
	public Car(String id, String nome, String placa, String imageUrl) {
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.imageUrl = imageUrl;
	}

	public Car() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
