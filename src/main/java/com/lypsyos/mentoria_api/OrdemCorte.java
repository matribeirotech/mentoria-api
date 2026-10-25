package com.lypsyos.mentoria_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Diz ao JPA: "Crie uma tabela no banco de dados baseada nesta classe"

public class OrdemCorte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String material;
	private double espessuraMm;
	
	// Construct vazio para o JPA
	public OrdemCorte() {}
	
	public OrdemCorte(String material, double espessuraMm) {
		this.material = material;
		this.espessuraMm = espessuraMm;
	}
	public Long getId() {
		return id;
	}
}
